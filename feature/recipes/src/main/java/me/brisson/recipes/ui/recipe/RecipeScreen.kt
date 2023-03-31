package me.brisson.recipes.ui.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.recipes.domain.model.Recipe
import me.brisson.recipes.ui.preview_provider.RecipePreviewProvider
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.gothicA1

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeViewModel = hiltViewModel(),
    onBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    uiState.recipe?.let { recipe ->
        RecipeScreen(
            modifier = modifier,
            recipe = recipe,
            selectedTab = uiState.selectedTab,
            onTab = viewModel::changeTab,
            onBack = onBack
        )
    }
}

@Composable
internal fun RecipeScreen(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    selectedTab: RecipeTab,
    onTab: (tab: RecipeTab) -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            IconButton(modifier = Modifier.padding(10.dp), onClick = onBack) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBackIosNew,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 12.dp),
                text = recipe.name,
                color = Color.White,
                fontFamily = gothicA1,
                fontWeight = FontWeight.Black,
                fontSize = 28.sp,
                letterSpacing = (-1).sp
            )

            RecipeDetails(
                modifier = Modifier
                    .height(40.dp)
                    .padding(bottom = 12.dp),
                recipe = recipe
            )
        }

        RecipeTabSelector(
            modifier.padding(20.dp).height(40.dp),
            tab = selectedTab,
            onTab = onTab
        )

        when (selectedTab) {
            is RecipeTab.Ingredient -> {
                recipe.ingredients.forEach { Text(it.name) } //Todo: Make ingredient component
            }
            is RecipeTab.Instructions -> {
                recipe.instructions.forEach { Text(it) } //Todo: Make instructions component
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipeScreen(@PreviewParameter(RecipePreviewProvider::class) recipe: Recipe) {
    FruitAppTheme {
        RecipeScreen(
            recipe = recipe,
            selectedTab = RecipeTab.Ingredient(),
            onTab = { },
            onBack = { }
        )
    }
}