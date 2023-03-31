package me.brisson.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.brisson.domain.model.Ingredient

@Entity(tableName = "Ingredient")
data class IngredientEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ingredientId")
    val id: Long = 0,
    val name: String,
    val amount: String,
    val unitMeasurement: String?,
    val observations: List<String>? = null,
    val recipeId: Long
) {
    fun toIngredient(): Ingredient {
        return Ingredient(
            id = id,
            name = name,
            amount = amount,
            unitMeasurement = unitMeasurement,
            observations = observations,
        )
    }
}

fun Ingredient.toIngredientEntity(recipeId: Long): IngredientEntity {
    return IngredientEntity(
        id = id,
        name = name,
        unitMeasurement = unitMeasurement,
        amount = amount,
        observations = observations,
        recipeId = recipeId,
    )
}