package me.brisson.fruits.ui.presentation.home

import me.brisson.domain.model.Fruit

data class HomeUiState(
    val fruitsLoading: Boolean = true,
    val fruitsError: Throwable? = null,
    val fruits: List<Fruit> = emptyList(),
    val greetings: String = "",
)
