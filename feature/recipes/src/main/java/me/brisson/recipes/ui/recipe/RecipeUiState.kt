package me.brisson.recipes.ui.recipe

import me.brisson.domain.model.Recipe

data class RecipeUiState(
    val missingRecipeId: Boolean = false,

    val recipe: Recipe? = null,
    val loading: Boolean = true,
    val recipeError: Throwable? = null,

    val selectedTab: RecipeTab = RecipeTab.Ingredient()
)

sealed class RecipeTab(open val name: String) {
    data class Ingredient(override val name: String = "Ingredientes"): RecipeTab(name)
    data class Instructions(override val name: String = "Modo de preparo"): RecipeTab(name)
}
