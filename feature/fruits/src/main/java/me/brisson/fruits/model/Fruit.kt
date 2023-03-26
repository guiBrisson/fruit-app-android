package me.brisson.fruits.model

data class Fruit(
    val id: Long = -1,
    val name: String,
    val imageUrl: String? = null,
    val summary: String
)
