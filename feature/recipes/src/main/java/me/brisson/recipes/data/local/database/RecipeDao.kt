package me.brisson.recipes.data.local.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.brisson.recipes.data.local.entity.IngredientEntity
import me.brisson.recipes.data.local.entity.RecipeEntity
import me.brisson.recipes.data.local.relation.RecipeWithIngredients

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(recipe: RecipeEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIngredient(vararg ingredientEntity: IngredientEntity)

    @Transaction
    @Query("SELECT * FROM Recipe")
    fun getRecipesWithIngredients(): Flow<List<RecipeWithIngredients>>

    @Transaction
    @Query("SELECT * FROM Recipe WHERE recipeId LIKE :id")
    fun getRecipeWithIngredientsById(id: Long): Flow<RecipeWithIngredients>
}
