package me.brisson.data.database.repository

import kotlinx.coroutines.flow.*
import me.brisson.data.database.dao.FruitDao
import me.brisson.data.database.dao.FruitMonthDao
import me.brisson.data.database.dao.MonthDao
import me.brisson.data.database.entity.toFruitEntity
import me.brisson.data.database.entity.toMonthEntity
import me.brisson.data.database.relation.FruitMonthCrossRef
import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Month
import me.brisson.domain.repository.FruitMonthRepository
import javax.inject.Inject

class FruitMonthRepositoryImpl @Inject constructor(
    private val fruitDao: FruitDao,
    private val monthDao: MonthDao,
    private val fruitMonthDao: FruitMonthDao
) : FruitMonthRepository {

    override suspend fun addFruit(fruit: Fruit) {
        // Adding fruit to fruit database
        val fruitId = fruitDao.insertFruit(fruit.toFruitEntity())

        fruit.months?.forEach { month ->
            // Creating month if it does not exists
            if (!monthDao.doesMonthExists(month.name)) {
                monthDao.insertMonth(month.toMonthEntity())
            }

            // Creating relation between fruit and month
            fruitMonthDao.insertFruitMonthCrossRef(
                FruitMonthCrossRef(
                    fruitId = fruitId,
                    monthName = month.name
                )
            )
        }
    }

    override suspend fun updateFruit(fruit: Fruit) {
        fruitDao.updateFruit(fruit.toFruitEntity())

        // Updating months if not null or empty
        fruit.months?.forEach { month ->
            // Creating month if does not exists
            if (!monthDao.doesMonthExists(month.name)) {
                monthDao.insertMonth(month.toMonthEntity())
            }

            // Updating relation between fruit and month
            fruitMonthDao.updateFruitMonthCrossRef(
                FruitMonthCrossRef(
                    fruitId = fruit.id,
                    monthName = month.name
                )
            )
        }

    }

    override suspend fun addMonth(vararg month: Month) {
        // Adding each month to the database
        month.forEach { monthDao.insertMonth(it.toMonthEntity()) }
    }

    override fun getAllFruits(): Flow<List<Fruit>> {
        // Mapping Flow<List<FruitWithMonths>> to Flow<List<Fruit>>
        return fruitMonthDao.getAllFruitsWithMonths().map { it.map { f -> f.toFruit() } }
    }

    override fun getFruitById(id: Long): Flow<Fruit> {
        // Mapping Flow<FruitWithMonths> to Flow<Fruit>
        return fruitMonthDao.getMonthsOfFruit(id).map { it.toFruit() }
    }

    override fun getAllMonths(): Flow<List<Month>> {
        // Mapping Flow<List<MonthWithFruits>> to Flow<List<Month>>
        return fruitMonthDao.getAllMonthsWithFruits().map { it.map { m -> m.toMonth() } }
    }


    override fun getMonthByName(name: String): Flow<Month> {
        // Mapping Flow<MonthWithFruits> to Flow<Month>
        return fruitMonthDao.getFruitsOfMonth(name).map { it.toMonth() }
    }

}