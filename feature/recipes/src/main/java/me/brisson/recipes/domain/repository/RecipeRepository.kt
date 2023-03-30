package me.brisson.recipes.domain.repository

import kotlinx.coroutines.flow.Flow
import me.brisson.recipes.domain.model.Recipe

interface RecipeRepository {

    suspend fun insertRecipe(recipe: Recipe)

    fun getAllRecipes(): Flow<List<Recipe>>

    fun getRecipeById(recipeId: Long): Flow<Recipe>
}