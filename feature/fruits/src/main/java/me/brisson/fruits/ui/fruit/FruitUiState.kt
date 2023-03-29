package me.brisson.fruits.ui.fruit

import me.brisson.domain.model.Fruit

data class FruitUiState(
    val loading: Boolean = true,
    val fruit: Fruit? = null,
    val fruitError: Throwable? = null,
    val missingFruitId: Boolean = false,
)
