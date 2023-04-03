package me.brisson.fruits.ui.presentation.fruit_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.domain.model.Fruit
import me.brisson.fruits.ui.preview_provider.FruitPreviewProvider
import me.brisson.ui.R
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.gothicA1

@Composable
fun FruitDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: FruitDetailViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    uiState.fruit?.let { fruit ->
        FruitDetailScreen(
            modifier = modifier,
            fruit = fruit,
            onFavorite = viewModel::favoriteFruit,
            onBack = onBack
        )
    }

}

@Composable
internal fun FruitDetailScreen(
    modifier: Modifier = Modifier,
    fruit: Fruit,
    onFavorite: (favorite: Boolean) -> Unit,
    onBack: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBackIosNew,
                        contentDescription = null
                    )
                }
                IconButton(onClick = { onFavorite(!fruit.isFavorite) }) {
                    if (fruit.isFavorite) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart_filled),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )

                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = null,
                        )
                    }
                }
            }
        }

        item {
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = fruit.name,
                style = MaterialTheme.typography.h1
            )
        }

        item {
            Text(
                modifier = Modifier.padding(horizontal = 20.dp),
                text = fruit.summary,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)
            )
        }

        item {
            fruit.months?.let { months ->
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 24.dp),
                    text = "Meses de safra",
                    fontFamily = gothicA1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                if (months.size == 12) {
                    val periwinkle = Color(0xFFC9DDFF)
                    val plum = Color(0xFFECB0E1)
                    val aquamarine = Color(0xFF2CF6B3)

                    val colors =
                        Brush.linearGradient(listOf(periwinkle, plum, aquamarine))
                    MonthTag(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                        text = "Ano todo!",
                        textColor = colors
                    )

                } else {
                    LazyRow(modifier = Modifier.padding(vertical = 12.dp)) {
                        itemsIndexed(months) { index, month ->
                            val padding = when (index) {
                                0 -> PaddingValues(start = 20.dp, end = 4.dp)
                                months.lastIndex -> PaddingValues(start = 4.dp, end = 20.dp)
                                else -> PaddingValues(horizontal = 4.dp)

                            }

                            MonthTag(modifier = Modifier.padding(padding), text = month.name)
                        }
                    }
                }

            }
        }

        if (fruit.paragraphs.isNotEmpty()) {
            itemsIndexed(fruit.paragraphs) { index, paragraph ->
                val padding = when (index) {
                    0 -> PaddingValues(start = 20.dp, end = 20.dp, top = 12.dp)
                    fruit.paragraphs.lastIndex -> PaddingValues(
                        start = 20.dp,
                        end = 20.dp,
                        top = 4.dp,
                        bottom = 20.dp
                    )
                    else -> PaddingValues(start = 20.dp, end = 20.dp, top = 4.dp)

                }

                Text(
                    modifier = Modifier.padding(padding),
                    text = paragraph,
                    fontFamily = gothicA1,
                    fontSize = 16.sp
                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewFruitDetailScreen(@PreviewParameter(FruitPreviewProvider::class) fruits: List<Fruit>) {
    FruitAppTheme {
        FruitDetailScreen(
            fruit = fruits[2],
            onFavorite = { },
            onBack = { }
        )
    }
}