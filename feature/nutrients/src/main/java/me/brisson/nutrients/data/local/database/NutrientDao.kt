package me.brisson.nutrients.data.local.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.brisson.nutrients.domain.model.Nutrient

@Dao
interface NutrientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNutrients(vararg item: Nutrient)

    @Query("SELECT * FROM nutrient")
    fun getAllNutrients(): Flow<List<Nutrient>>

    @Query("SELECT * FROM nutrient WHERE nutrientId LIKE :id")
    fun getNutrientById(id: Long): Flow<Nutrient>

    @Delete
    suspend fun deleteNutrient(item: Nutrient)
}