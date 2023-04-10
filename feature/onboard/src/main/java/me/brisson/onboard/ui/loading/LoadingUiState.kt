package me.brisson.onboard.ui.loading

data class LoadingUiState(
    val loadingFruits: Boolean = false,
    val loadingMonths: Boolean = false,
    val loadingRecipes: Boolean = false,
    val loadingNutrients: Boolean = false,
)
