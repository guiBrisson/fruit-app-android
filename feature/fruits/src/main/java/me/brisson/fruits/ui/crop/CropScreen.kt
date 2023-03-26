package me.brisson.fruits.ui.crop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.brisson.fruits.model.Month
import me.brisson.fruits.model.MonthsPreviewProvider
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.backgroundGreen

@Composable
fun CropScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    CropScreen(
        modifier = modifier,
        months = listOf(),
        onBack = onBack
    )
}

@Composable
internal fun CropScreen(
    modifier: Modifier = Modifier,
    months: List<Month>,
    onBack: () -> Unit
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(backgroundGreen)) {
        IconButton(modifier = Modifier.padding(top = 10.dp, start = 10.dp), onClick = onBack) {
            Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = null)
        }
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "Safra das frutas",
            style = MaterialTheme.typography.h1
        )
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = "A melhor maneira de colocar mais nutrientes no cardápio é" +
                    " aproveitando o período de safra, onde os alimentos não precisam de" +
                    " pesticidas para crescer com saúde.",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
        )
        Text(
            modifier = Modifier.padding(top = 28.dp, bottom = 16.dp, start = 20.dp),
            text = "Meses",
            style = MaterialTheme.typography.h3
        )

        if (months.isNotEmpty()) {
            //Todo
        }
    }
}

@Preview
@Composable
fun PreviewCropScreen(@PreviewParameter(MonthsPreviewProvider::class) months: List<Month>) {
    FruitAppTheme {
        CropScreen(months = months,onBack = { })
    }
}