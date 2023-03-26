package me.brisson.fruits.ui.nutrient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.backgroundGreen


@Composable
fun NutrientScreen(
    modifier: Modifier = Modifier,
    onStartRead: () -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundGreen)
            .padding(20.dp)
    ) {
        IconButton(onClick = onBack) {
            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
        }
        Text(text = "Safra das frutas", style = MaterialTheme.typography.h1)
        Text(
            text = "A melhor maneira de colocar mais nutrientes no   é aproveitando o período de safra, onde os alimentos não precisam de pesticidas para crescer com saúde.",
        )
    }

}

@Preview
@Composable
fun PreviewNutrientScreen() {
    FruitAppTheme {
        NutrientScreen(onStartRead = { }, onBack = { })
    }
}