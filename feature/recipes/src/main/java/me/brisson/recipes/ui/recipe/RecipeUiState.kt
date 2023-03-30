package me.brisson.recipes.ui.recipe

import me.brisson.recipes.domain.model.Recipe

data class RecipeUiState(
    val recipe: Recipe? = null,
    val loading: Boolean = true,
    val recipeError: Throwable? = null
)
