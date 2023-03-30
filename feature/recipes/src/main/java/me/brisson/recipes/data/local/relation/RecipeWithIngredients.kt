package me.brisson.recipes.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import me.brisson.recipes.data.local.entity.IngredientEntity
import me.brisson.recipes.data.local.entity.RecipeEntity
import me.brisson.recipes.domain.model.Recipe

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
