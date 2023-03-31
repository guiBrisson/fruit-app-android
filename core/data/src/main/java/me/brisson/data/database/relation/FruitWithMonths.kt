package me.brisson.data.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import me.brisson.data.database.entity.FruitEntity
import me.brisson.data.database.entity.MonthEntity
import me.brisson.domain.model.Fruit

data class FruitWithMonths(
    @Embedded val fruitEntity: FruitEntity,
    @Relation(
        parentColumn = "fruitId",
        entityColumn = "monthName",
        associateBy = Junction(FruitMonthCrossRef::class)
    )
    val monthEntity: List<MonthEntity>
) {
    fun toFruit(): Fruit {
        val fruit = fruitEntity.toFruit()
        return fruit.copy(months = monthEntity.map { it.toMonth() })
    }
}
