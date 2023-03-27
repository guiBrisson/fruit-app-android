package me.brisson.domain.model

data class Fruit(
    val id: Long = 0,
    val name: String,
    val summary: String,
    val isFavorite: Boolean = false,
    val months: List<Month>? = emptyList()
)
