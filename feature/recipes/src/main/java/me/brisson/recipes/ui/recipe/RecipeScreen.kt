package me.brisson.recipes.ui.recipe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.recipes.domain.model.Recipe
import me.brisson.recipes.ui.preview_provider.RecipePreviewProvider
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    uiState.recipe?.let { recipe ->
        RecipeScreen(recipe = recipe, onBack = onBack)
    }
}

@Composable
internal fun RecipeScreen(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    onBack: () -> Unit,
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = recipe.toString())
    }
}

@Preview
@Composable
fun PreviewRecipeScreen(@PreviewParameter(RecipePreviewProvider::class) recipe: Recipe) {
    FruitAppTheme {
        RecipeScreen(recipe = recipe, onBack = { })
    }
}