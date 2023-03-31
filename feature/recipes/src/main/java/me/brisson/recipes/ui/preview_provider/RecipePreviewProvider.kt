package me.brisson.recipes.ui.preview_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.brisson.domain.recipeTest
import me.brisson.domain.model.Recipe

class RecipePreviewProvider: PreviewParameterProvider<Recipe> {
    override val values = sequenceOf(recipeTest)
}