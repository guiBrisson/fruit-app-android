package me.brisson.nutrients.ui.nutrients

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brisson.nutrients.ui.theme.NutrientsTheme
import me.brisson.nutrients.R
import me.brisson.nutrients.domain.model.Nutrient

@Composable
fun NutrientsSideBar(
    modifier: Modifier = Modifier,
    nutrientsList: List<Nutrient>,
    selectedNutrient: Nutrient,
    onItemClick: (Nutrient) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        item {
            Text(
                modifier = Modifier.padding(
                    top = 32.dp,
                    start = 20.dp,
                    end = 55.dp,
                    bottom = 20.dp
                ),
                text = "Nutrientes importantes",
                fontWeight = FontWeight.Black,
                fontSize = 24.sp,
                color = MaterialTheme.colors.onBackground
            )
        }
        items(nutrientsList) { nutrient ->
            val fontWeight = if (nutrient == selectedNutrient) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            }
            val fontSize = if (nutrient == selectedNutrient) {
                16.sp
            } else {
                14.sp
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { onItemClick(nutrient) }
                    .padding(horizontal = 28.dp, vertical = 12.dp)
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier,
                    text = nutrient.name,
                    fontWeight = fontWeight,
                    fontSize = fontSize,
                    color = MaterialTheme.colors.onBackground
                )
                if (nutrient == selectedNutrient) {
                    Icon(
                        modifier = Modifier.padding(start = 8.dp),
                        painter = painterResource(id = R.drawable.ei_pointer),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyListNutrient(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onBackground,
    onReload: () -> Unit,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Deu algo errado com a lista de nutrientes",
            color = color.copy(alpha = 0.6f),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        TextButton(modifier = Modifier.padding(top = 8.dp), onClick = onReload) {
            Text(text = "Clique aqui para recarregar", color = color, textAlign = TextAlign.Center)
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNutrientsSideBar() {
    NutrientsTheme {
        val nutrients = listOf(
            Nutrient(
                id = 1,
                name = "Flavonoides",
                subTitle = "Melhor amigo dos Flávios",
                paragraphs = listOf(
                    "ffffffffffffffffffffffffffffffffff",
                    "ffffffffffffffffffffffffffffff"
                )
            ),
            Nutrient(
                id = 2,
                name = "Vitamina C",
                subTitle = "Melhor amigo dos velhos",
                paragraphs = listOf(
                    "cccccccccccccccccccccccccccccccc",
                    "ccccccccccccccccccccccccccccccccc"
                )
            )
        )
        NutrientsSideBar(
            nutrientsList = nutrients,
            selectedNutrient = nutrients[0],
            onItemClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmptyListNutrient() {
    NutrientsTheme {
        EmptyListNutrient(onReload = { })
    }
}
