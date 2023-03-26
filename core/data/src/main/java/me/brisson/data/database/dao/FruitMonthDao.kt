package me.brisson.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.brisson.data.database.relation.FruitMonthCrossRef
import me.brisson.data.database.relation.FruitWithMonths
import me.brisson.data.database.relation.MonthWithFruits

@Dao
interface FruitMonthDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFruitMonthCrossRef(fruitMonthCrossRef: FruitMonthCrossRef)

    @Transaction
    @Query("SELECT * FROM fruit")
    fun getAllFruitsWithMonths(): Flow<List<FruitWithMonths>>

    @Transaction
    @Query("SELECT * FROM month")
    fun getAllMonthsWithFruits(): Flow<List<MonthWithFruits>>

    @Transaction
    @Query("SELECT * FROM fruit WHERE fruitId = :fruitId")
    fun getMonthsOfFruit(fruitId: Long): Flow<FruitWithMonths>

    @Transaction
    @Query("SELECT * FROM month WHERE monthName = :name")
    fun getFruitsOfMonth(name: String): Flow<MonthWithFruits>

    @Delete
    suspend fun deleteFruitMonthCrossRef(fruitMonthCrossRef: FruitMonthCrossRef)
}
