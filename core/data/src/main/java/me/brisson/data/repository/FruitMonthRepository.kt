package me.brisson.data.repository

import kotlinx.coroutines.flow.Flow
import me.brisson.data.model.Fruit
import me.brisson.data.model.Month


interface FruitMonthRepository {
    suspend fun addFruit(fruit: Fruit)
    suspend fun addMonth(vararg month: Month)
    fun getAllFruits(): Flow<List<Fruit>>
    fun getFruitById(id: Long): Flow<Fruit>
    fun getAllMonths(): Flow<List<Month>>
    fun getMonthByName(name: String): Flow<Month>
}