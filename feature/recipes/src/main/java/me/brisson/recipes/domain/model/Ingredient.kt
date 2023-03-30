package me.brisson.recipes.domain.model

data class Ingredient(
    val id: Long = 0,
    val name: String,
    val amount: String,
    val unitMeasurement: String? = null,
    val observations: List<String>? = null
)
