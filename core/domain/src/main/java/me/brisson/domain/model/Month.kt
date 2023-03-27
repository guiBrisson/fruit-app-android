package me.brisson.domain.model

data class Month(
    val name: String,
    val number: Int,
    val fruits: List<Fruit>? = null
)
