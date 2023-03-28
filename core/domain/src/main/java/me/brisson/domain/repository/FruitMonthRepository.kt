package me.brisson.domain.repository

import kotlinx.coroutines.flow.Flow
import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Month

interface FruitMonthRepository {
    suspend fun addFruit(fruit: Fruit)
    suspend fun updateFruit(fruit: Fruit)
    suspend fun addMonth(vararg month: Month)
    fun getAllFruits(): Flow<List<Fruit>>
    fun getFruitById(id: Long): Flow<Fruit>
    fun getAllMonths(): Flow<List<Month>>
    fun getMonthByName(name: String): Flow<Month>
}