package me.brisson.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.brisson.domain.model.Recipe

@Entity(tableName = "Recipe")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "recipeId")
    val id: Long = 0,
    val name: String,
    val portions: String,
    val calories: Int,
    val preparationTime: Int,
    val waitingTime: Int?,
    val instructions: List<String>,
    val observations: List<String>? = null,
) {
    fun toRecipe(): Recipe {
        return Recipe(
            id = id,
            name = name,
            portions = portions,
            calories = calories,
            preparationTime = preparationTime,
            waitingTime = waitingTime,
            instructions = instructions,
            ingredients = emptyList(),
            observations = observations,
        )
    }
}

fun Recipe.toRecipeEntity() : RecipeEntity {
    return RecipeEntity(
        id = id,
        name = name,
        portions = portions,
        calories = calories,
        preparationTime = preparationTime,
        waitingTime = waitingTime,
        instructions = instructions,
        observations = observations,
    )
}
