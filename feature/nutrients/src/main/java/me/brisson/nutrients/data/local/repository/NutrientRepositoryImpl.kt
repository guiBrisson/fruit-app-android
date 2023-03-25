package me.brisson.nutrients.data.local.repository

import kotlinx.coroutines.flow.Flow
import me.brisson.nutrients.data.local.database.NutrientDao
import me.brisson.nutrients.domain.repository.NutrientRepository
import me.brisson.nutrients.domain.model.Nutrient

class NutrientRepositoryImpl(private val dao: NutrientDao) : NutrientRepository {

    override suspend fun insertNutrients(vararg item: Nutrient) {
        return dao.insertNutrients(*item)
    }

    override fun getAllNutrients(): Flow<List<Nutrient>> {
        return dao.getAllNutrients()
    }

    override fun getNutrientsById(id: Long): Flow<Nutrient> {
        return dao.getNutrientById(id)
    }

    override suspend fun deleteNutrient(nutrient: Nutrient) {
        return dao.deleteNutrient(nutrient)
    }
}