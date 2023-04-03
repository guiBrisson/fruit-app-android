package me.brisson.fruits.ui.presentation.fruit

import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Recipe

data class FruitUiState(
    val missingFruitId: Boolean = false,

    val loading: Boolean = true,
    val fruit: Fruit? = null,
    val fruitError: Throwable? = null,

    val recipesLoading: Boolean = true,
    val recipes: List<Recipe> = emptyList(),
    val recipesError: Throwable? = null
)
