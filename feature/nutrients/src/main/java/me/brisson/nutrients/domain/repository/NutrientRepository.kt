package me.brisson.nutrients.domain.repository

import kotlinx.coroutines.flow.Flow
import me.brisson.nutrients.domain.model.Nutrient

interface NutrientRepository {

    suspend fun insertNutrients(vararg item: Nutrient)

    fun getAllNutrients(): Flow<List<Nutrient>>

    fun getNutrientsById(id: Long): Flow<Nutrient>

    suspend fun deleteNutrient(nutrient: Nutrient)
}