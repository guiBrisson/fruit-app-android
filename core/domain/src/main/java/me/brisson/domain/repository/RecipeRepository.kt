package me.brisson.domain.repository

import kotlinx.coroutines.flow.Flow
import me.brisson.domain.model.Recipe

interface RecipeRepository {

    suspend fun insertRecipe(recipe: Recipe, fruitId: Long)

    fun getAllRecipesFromFruit(fruitId: Long): Flow<List<Recipe>>

    fun getAllRecipes(): Flow<List<Recipe>>

    fun getRecipeById(recipeId: Long): Flow<Recipe>
}