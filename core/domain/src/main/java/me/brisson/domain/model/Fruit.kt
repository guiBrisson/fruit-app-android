package me.brisson.domain.model

data class Fruit(
    val id: Long = 0,
    val name: String,
    val imageUrl: String? = null,
    val summary: String,
    var isFavorite: Boolean = false,
    val paragraphs: List<String> = emptyList(),
    val months: List<Month>? = emptyList(),
)
