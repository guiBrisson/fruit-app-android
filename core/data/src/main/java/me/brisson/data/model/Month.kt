package me.brisson.data.model

data class Month(
    val name: String,
    val number: Int,
    val fruits: List<Fruit>? = null
)
