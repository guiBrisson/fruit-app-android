package me.brisson.recipes.ui.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.brisson.recipes.R
import me.brisson.domain.model.Recipe
import me.brisson.recipes.ui.preview_provider.RecipePreviewProvider
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun RecipeDetails(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    backgroundColor: Color = Color.Black,
    contentColor: Color = Color.White,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RecipeDetailItem(
            modifier = Modifier.weight(1f),
            text = "${recipe.preparationTime} minuto(s)",
            iconPainter = painterResource(id = R.drawable.ic_clock),
            contentColor = contentColor,
        )
        RecipeDetailItem(
            modifier = Modifier.weight(1f),
            text = "${recipe.calories} kcal",
            iconPainter = painterResource(id = R.drawable.ic_weight),
            contentColor = contentColor,
        )
        RecipeDetailItem(
            modifier = Modifier.weight(1f),
            text = "${recipe.portions} porção(s)",
            iconPainter = painterResource(id = R.drawable.ic_bow),
            contentColor = contentColor,
        )

    }
}

@Composable
private fun RecipeDetailItem(
    modifier: Modifier = Modifier,
    text: String,
    iconPainter: Painter,
    iconContentDescription: String? = null,
    contentColor: Color = Color.White,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier.padding(end = 8.dp),
            painter = iconPainter,
            contentDescription = iconContentDescription,
            tint = contentColor
        )
        Text(text = text, color = contentColor)
    }
}

@Composable
fun RecipeTabSelector(
    modifier: Modifier = Modifier,
    tab: RecipeTab,
    onTab: (tab: RecipeTab) -> Unit,
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black, RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val tabModifier = Modifier.weight(1f).fillMaxHeight()

        TabItem(
            modifier = tabModifier.clickable { onTab(RecipeTab.Ingredient()) },
            tab = RecipeTab.Ingredient(),
            isSelected = (tab == RecipeTab.Ingredient())
        )

        TabItem(
            modifier = tabModifier.clickable { onTab(RecipeTab.Instructions()) },
            tab = RecipeTab.Instructions(),
            isSelected = (tab == RecipeTab.Instructions())
        )
    }
}

@Composable
private fun TabItem(
    modifier: Modifier = Modifier,
    tab: RecipeTab,
    isSelected: Boolean = false,
    shape: Shape = RoundedCornerShape(8.dp)
) {
    val backgroundColor: Color = if (isSelected) Color.Black else Color.White
    val contentColor: Color = if (isSelected) Color.White else Color.Black

    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = tab.name, color = contentColor)
    }
}

@Preview
@Composable
fun PreviewRecipeDetails(@PreviewParameter(RecipePreviewProvider::class) recipe: Recipe) {
    FruitAppTheme {
        RecipeDetails(recipe = recipe)
    }
}

@Preview
@Composable
fun RecipeTabSelector() {
    FruitAppTheme {
        var selectedTab by remember {
            mutableStateOf<RecipeTab>(RecipeTab.Ingredient())
        }

        RecipeTabSelector(
            modifier = Modifier.height(50.dp),
            tab = selectedTab,
            onTab = { tab -> selectedTab = tab }
        )

    }
}
