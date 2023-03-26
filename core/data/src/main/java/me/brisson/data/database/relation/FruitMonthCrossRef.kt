package me.brisson.data.database.relation

import androidx.room.Entity

@Entity(primaryKeys = ["fruitId", "monthName"])
data class FruitMonthCrossRef(
    val fruitId: Long,
    val monthName: String
)