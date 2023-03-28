package me.brisson.nutrients.ui.nutrients

import me.brisson.nutrients.domain.model.Nutrient

data class NutrientsUiState(
    val loading: Boolean = true,
    val nutrients: List<Nutrient> = emptyList(),
    val error: Throwable? = null,
//    val nextNutrient: Nutrient? = null,
//    val selectedNutrient: Nutrient? = null
)
