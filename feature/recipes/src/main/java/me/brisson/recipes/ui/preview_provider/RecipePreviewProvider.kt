package me.brisson.recipes.ui.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.brisson.recipes.data.local.recipeTest
import me.brisson.recipes.domain.model.Recipe

class RecipePreviewProvider: PreviewParameterProvider<Recipe> {
    override val values = sequenceOf(recipeTest)
}