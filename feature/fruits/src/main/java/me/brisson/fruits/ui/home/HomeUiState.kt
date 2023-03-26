package me.brisson.fruits.ui.home

import me.brisson.fruits.model.Fruit

data class HomeUiState(
    val fruitsLoading: Boolean = true,
    val fruitsError: Throwable? = null,
    val fruits: List<Fruit> = emptyList()
)
