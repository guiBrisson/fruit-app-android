package me.brisson.nutrients.ui.nutrients

data class NutrientsUiState(
    val loading: Boolean = true,
    val nutrients: List<String> = emptyList(),
    val error: Throwable? = null
)
