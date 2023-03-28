package me.brisson.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.brisson.data.database.entity.FruitEntity

@Dao
interface FruitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFruit(fruitEntity: FruitEntity): Long

    @Update
    suspend fun updateFruit(fruitEntity: FruitEntity)

    @Query("SELECT * FROM fruit")
    fun getAllFruits(): Flow<List<FruitEntity>>

    @Query("SELECT * FROM fruit WHERE fruitId LIKE :id")
    fun getFruitById(id: Long): Flow<FruitEntity>

    @Delete
    suspend fun deleteFruit(vararg fruitEntity: FruitEntity)
}
