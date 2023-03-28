package me.brisson.fruits.ui.crop_season

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.domain.model.Month
import me.brisson.ui.preview_provider.MonthsPreviewProvider
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.backgroundGreen

@Composable
fun CropSeasonScreen(
    modifier: Modifier = Modifier,
    viewModel: CropSeasonViewModel = hiltViewModel(),
    onMonth: (monthName: String) -> Unit,
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()


    CropSeasonScreen(
        modifier = modifier,
        months = uiState.months,
        currentMonth = viewModel.currentMonth(),
        onMonth = onMonth,
        onBack = onBack
    )
}

@Composable
internal fun CropSeasonScreen(
    modifier: Modifier = Modifier,
    months: List<Month>,
    currentMonth: Month?,
    onMonth: (monthName: String) -> Unit,
    onBack: () -> Unit
) {
    val spanCount = 2
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundGreen), columns = GridCells.Fixed(spanCount)
    ) {
        item(span = { GridItemSpan(spanCount) }) {
            Row {
                IconButton(
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp),
                    onClick = onBack
                ) {
                    Icon(imageVector = Icons.Rounded.ArrowBackIosNew, contentDescription = null)
                }
            }
        }
        item(span = { GridItemSpan(spanCount) }) {
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(
                    text = "Safra das frutas",
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = "A melhor maneira de colocar mais nutrientes no cardápio é" +
                            " aproveitando o período de safra, onde os alimentos não precisam de" +
                            " pesticidas para crescer com saúde.",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f),
                )
            }
        }
        item(span = { GridItemSpan(spanCount) }) {
            Text(
                modifier = Modifier.padding(top = 28.dp, bottom = 8.dp, start = 20.dp),
                text = "Meses",
                style = MaterialTheme.typography.h3
            )
        }

        if (months.isNotEmpty()) {
            itemsIndexed(months) { index, month ->
                val padding = if (index % 2 == 0) {
                    PaddingValues(start = 20.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                } else {
                    PaddingValues(start = 8.dp, end = 20.dp, top = 8.dp, bottom = 8.dp)
                }

                MonthsItem(
                    modifier = Modifier
                        .padding(padding)
                        .clickable { onMonth(month.name) },
                    month = month,
                    currentMonth = currentMonth
                )

            }
        }
    }
}

@Preview
@Composable
fun PreviewCropScreen(@PreviewParameter(MonthsPreviewProvider::class) months: List<Month>) {
    FruitAppTheme {
        CropSeasonScreen(months = months, currentMonth = months[2], onMonth = { }, onBack = { })
    }
}