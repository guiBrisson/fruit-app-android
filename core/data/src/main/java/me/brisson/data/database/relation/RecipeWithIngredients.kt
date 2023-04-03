package me.brisson.data.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import me.brisson.data.database.entity.IngredientEntity
import me.brisson.data.database.entity.RecipeEntity
import me.brisson.domain.model.Recipe

data class RecipeWithIngredients(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipeId",
        entityColumn = "recipeId"
    )
    val ingredients: List<IngredientEntity>
) {
    fun toRecipe(): Recipe {
        return recipe.toRecipe().copy(ingredients = ingredients.map { it.toIngredient() })
    }
}
