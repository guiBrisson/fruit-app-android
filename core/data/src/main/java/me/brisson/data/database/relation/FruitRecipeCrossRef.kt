package me.brisson.data.database.relation

import androidx.room.Entity

@Entity(primaryKeys = ["fruitId", "recipeId"])
class FruitRecipeCrossRef(
    val fruitId: Long,
    val recipeId: Long
)