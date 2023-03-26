package me.brisson.fruits.ui.nutrient

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.brisson.ui.components.AppButton
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.backgroundOrange

@Composable
fun NutrientScreen(
    modifier: Modifier = Modifier,
    onStartRead: () -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundOrange)
    ) {
        IconButton(modifier = Modifier.padding(top = 10.dp, start = 10.dp), onClick = onBack) {
            Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = null)
        }
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Um mar de nutrientes",
            style = MaterialTheme.typography.h1
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Apenas 24,1% dos brasileiros ingere a quantidade de frutas e hortaliças" +
                    " recomendadas pela Organização Mundial de Saúde (OMS), que é de 400g ao dia.",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            AppButton(
                modifier = Modifier.width(200.dp),
                text = { Text(text = "Iniciar leitura", style = MaterialTheme.typography.button) },
                onClick = onStartRead,
            )
        }
    }

}

@Preview
@Composable
fun PreviewNutrientScreen() {
    FruitAppTheme {
        NutrientScreen(onStartRead = { }, onBack = { })
    }
}