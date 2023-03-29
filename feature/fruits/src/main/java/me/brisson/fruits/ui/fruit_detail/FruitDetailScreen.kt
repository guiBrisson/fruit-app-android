package me.brisson.fruits.ui.fruit_detail

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.domain.model.Fruit
import me.brisson.ui.R
import me.brisson.ui.preview_provider.FruitPreviewProvider
import me.brisson.ui.theme.FruitAppTheme

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
    Column(modifier = modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
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
        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = fruit.name,
            style = MaterialTheme.typography.h1
        )

        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = fruit.summary,
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.6f)
        )

    }
}

@Preview
@Composable
fun PreviewFruitDetailScreen(@PreviewParameter(FruitPreviewProvider::class) fruits: List<Fruit>) {
    FruitAppTheme {
        FruitDetailScreen(
            fruit = fruits.first(),
            onFavorite = { },
            onBack = { }
        )
    }
}