package me.brisson.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.brisson.data.database.entity.IngredientEntity
import me.brisson.data.database.entity.RecipeEntity
import me.brisson.data.database.relation.RecipeWithIngredients

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
