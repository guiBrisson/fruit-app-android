package me.brisson.recipes.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brisson.domain.model.Recipe
import me.brisson.recipes.ui.preview_provider.RecipePreviewProvider
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.recipes.R
import me.brisson.ui.theme.gothicA1

@Composable
fun RecipeItem(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    offset: Dp = 2.dp,
    shape: Shape = RoundedCornerShape(4.dp)
) {
    Box(modifier = Modifier.height(IntrinsicSize.Max)) {
        Box(
            modifier = modifier
                .matchParentSize()
                .offset(x = offset, y = offset)
                .clip(shape)
                .background(Color.Black)
        )

        Column(
            modifier = modifier
                .clip(shape)
                .background(Color.White)
                .border(BorderStroke(width = 1.dp, color = Color.Black), shape = shape),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val contentColor = Color.Black.copy(alpha = 0.6f)
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = R.drawable.ic_clock),
                    contentDescription = null,
                    tint = contentColor
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = "${recipe.preparationTime} minutos",
                    fontSize = 12.sp,
                    color = contentColor
                )
            }
            Text(
                modifier = Modifier.padding(8.dp),
                text = recipe.name,
                fontFamily = gothicA1,
                fontWeight = FontWeight.Light,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 4.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val contentColor = Color.Black.copy(alpha = 0.6f)
                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = R.drawable.ic_bow),
                    contentDescription = null,
                    tint = contentColor
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = recipe.portions,
                    fontSize = 12.sp,
                    color = contentColor
                )
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    modifier = Modifier.size(14.dp),
                    painter = painterResource(id = R.drawable.ic_weight),
                    contentDescription = null,
                    tint = contentColor
                )
                Text(
                    modifier = Modifier.padding(start = 2.dp),
                    text = "${recipe.calories} kcal",
                    fontSize = 12.sp,
                    color = contentColor
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeItem(@PreviewParameter(RecipePreviewProvider::class) recipe: Recipe) {
    FruitAppTheme {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp

        RecipeItem(modifier = Modifier.padding(10.dp).width(screenWidth / 2), recipe = recipe)
    }
}