package me.brisson.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.brisson.data.database.relation.FruitRecipeCrossRef
import me.brisson.data.database.relation.FruitWithRecipes

@Dao
interface FruitRecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFruitRecipeCrossRef(fruitRecipeCrossRef: FruitRecipeCrossRef)

    @Transaction
    @Query("SELECT * FROM fruit WHERE fruitId = :fruitId")
    fun getRecipesOfFruit(fruitId: Long): Flow<FruitWithRecipes>
}