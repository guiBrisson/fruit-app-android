package me.brisson.recipes.data.local.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.brisson.recipes.data.local.database.RecipeDao
import me.brisson.recipes.data.local.entity.toIngredientEntity
import me.brisson.recipes.data.local.entity.toRecipeEntity
import me.brisson.recipes.domain.model.Recipe
import me.brisson.recipes.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao
) : RecipeRepository {

    override suspend fun insertRecipe(recipe: Recipe) {
        // Inserting recipe on db and receiving it's id
        val recipeId = recipeDao.insertRecipe(recipe.toRecipeEntity())

        // Inserting all the ingredients to ingredient db with recipe id
        val ingredients = recipe.ingredients.map { it.toIngredientEntity(recipeId) }.toTypedArray()
        recipeDao.insertIngredient(*ingredients)
    }

    override fun getAllRecipes(): Flow<List<Recipe>> {
        // Mapping List<RecipeWithIngredients> from db, to List<Recipe>
        return recipeDao.getRecipesWithIngredients().map { it.map { it.toRecipe() } }
    }

    override fun getRecipeById(recipeId: Long): Flow<Recipe> {
        // Mapping RecipeWithIngredients from db, to Recipe
        return recipeDao.getRecipeWithIngredientsById(recipeId).map { it.toRecipe() }
    }
}