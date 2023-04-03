package me.brisson.data.database.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.brisson.data.database.dao.FruitRecipeDao
import me.brisson.data.database.dao.RecipeDao
import me.brisson.data.database.entity.toIngredientEntity
import me.brisson.data.database.entity.toRecipeEntity
import me.brisson.data.database.relation.FruitRecipeCrossRef
import me.brisson.domain.model.Recipe
import me.brisson.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao,
    private val fruitRecipeDao: FruitRecipeDao,
) : RecipeRepository {

    override suspend fun insertRecipe(recipe: Recipe, fruitId: Long) {
        // Inserting recipe on db and receiving it's id
        val recipeId = recipeDao.insertRecipe(recipe.toRecipeEntity())

        // Inserting all the ingredients to ingredient db with recipe id
        val ingredients = recipe.ingredients.map { it.toIngredientEntity(recipeId) }.toTypedArray()
        recipeDao.insertIngredient(*ingredients)

        // Creating relation between fruit and recipe
        fruitRecipeDao.insertFruitRecipeCrossRef(FruitRecipeCrossRef(fruitId, recipeId))
    }

    override fun getAllRecipesFromFruit(fruitId: Long): Flow<List<Recipe>> {
        // Mapping List<FruitWithRecipes> from db, to List<Recipe>
        return fruitRecipeDao.getRecipesOfFruit(fruitId).map {
            it.toRecipes()
        }
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