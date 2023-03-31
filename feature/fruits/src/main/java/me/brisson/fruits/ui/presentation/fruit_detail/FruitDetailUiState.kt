package me.brisson.fruits.ui.presentation.fruit_detail

import me.brisson.domain.model.Fruit

data class FruitDetailUiState(
    val loading: Boolean = true,
    val fruit: Fruit? = null,
    val fruitError: Throwable? = null,
    val missingFruitId: Boolean = false,
)
