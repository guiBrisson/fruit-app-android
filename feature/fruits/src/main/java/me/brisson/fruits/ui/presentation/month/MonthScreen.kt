package me.brisson.fruits.ui.presentation.month

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
import me.brisson.domain.model.Fruit
import me.brisson.domain.model.Month
import me.brisson.fruits.ui.components.FruitCardItem
import me.brisson.fruits.ui.preview_provider.MonthsPreviewProvider
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.backgroundGreen

@Composable
fun MonthScreen(
    modifier: Modifier = Modifier,
    viewModel: MonthViewModel = hiltViewModel(),
    onFruit: (fruitDd: Long) -> Unit,
    onBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    uiState.month?.let { month ->
        MonthScreen(
            modifier = modifier,
            month = month,
            onFruit = onFruit,
            onFavorite = { fruit -> viewModel.updateFruit(fruit) },
            onBack = onBack
        )
    }

}

@Composable
internal fun MonthScreen(
    modifier: Modifier = Modifier,
    month: Month?,
    onFruit: (fruitId: Long) -> Unit,
    onFavorite: (fruit: Fruit) -> Unit,
    onBack: () -> Unit,
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

        month?.let { month ->
            item(span = { GridItemSpan(spanCount) }) {
                Text(
                    modifier = modifier.padding(start = 20.dp, end = 20.dp, bottom = 8.dp),
                    text = month.name,
                    style = MaterialTheme.typography.h1
                )
            }

            month.fruits?.let { fruits ->
                itemsIndexed(fruits) { index, fruit ->
                    val paddingValues = if (index % 2 == 0) {
                        PaddingValues(start = 20.dp, end = 8.dp, bottom = 16.dp)
                    } else {
                        PaddingValues(start = 8.dp, end = 20.dp, bottom = 16.dp)
                    }
                    FruitCardItem(
                        modifier = Modifier
                            .padding(paddingValues)
                            .clickable { onFruit(fruit.id) },
                        fruit = fruit,
                        onFavorite = { favorite -> onFavorite(fruit.copy(isFavorite = favorite)) }
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.padding(bottom = 24.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewMonthScreen(@PreviewParameter(MonthsPreviewProvider::class) months: List<Month>) {
    FruitAppTheme {
        MonthScreen(
            month = months.first(),
            onFruit = { },
            onFavorite = { },
            onBack = { }
        )
    }
}
