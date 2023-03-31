package me.brisson.domain.model


data class Recipe(
    val id: Long = 0,
    val name: String,
    val portions: String,
    val calories: Int,
    val preparationTime: Int,
    val waitingTime: Int?,
    val ingredients: List<Ingredient>,
    val instructions: List<String>
)
