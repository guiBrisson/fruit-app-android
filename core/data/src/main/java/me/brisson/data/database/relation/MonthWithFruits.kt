package me.brisson.data.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import me.brisson.data.database.entity.FruitEntity
import me.brisson.data.database.entity.MonthEntity
import me.brisson.domain.model.Month

data class MonthWithFruits(
    @Embedded val monthEntity: MonthEntity,
    @Relation(
        parentColumn = "monthName",
        entityColumn = "fruitId",
        associateBy = Junction(FruitMonthCrossRef::class)
    )
    val fruitEntities: List<FruitEntity>
) {
    fun toMonth(): Month {
        return Month(
            name = monthEntity.name,
            number = monthEntity.number,
            fruits = fruitEntities.map { it.toFruit() },
        )
    }
}
