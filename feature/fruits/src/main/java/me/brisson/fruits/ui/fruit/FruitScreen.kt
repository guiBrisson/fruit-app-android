package me.brisson.fruits.ui.fruit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.domain.model.Fruit
import me.brisson.ui.R
import me.brisson.ui.components.AppButton
import me.brisson.ui.preview_provider.FruitPreviewProvider
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun FruitScreen(
    modifier: Modifier = Modifier,
    viewModel: FruitViewModel = hiltViewModel(),
    onSeeMore: (fruitId: Long) -> Unit,
    onRecipe: (recipeId: Long) -> Unit,
    onBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()

    uiState.fruit?.let { fruit ->
        FruitScreen(
            modifier = modifier,
            fruit = fruit,
            onFavorite = viewModel::favoriteFruit,
            onSeeMore = onSeeMore,
            onRecipe = onRecipe,
            onBack = onBack
        )
    }

}

@Composable
internal fun FruitScreen(
    modifier: Modifier = Modifier,
    fruit: Fruit,
    onFavorite: (favorite: Boolean) -> Unit,
    onSeeMore: (fruitId: Long) -> Unit,
    onRecipe: (recipeId: Long) -> Unit,
    onBack: () -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(fruit.imageUrl)
                    .crossfade(true)
                    .build(),
//                placeholder = painterResource(id = R.color.color_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FruitIconButton(onClick = onBack)
                FruitIconButton(
                    icon = {
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
                                tint = Color.White
                            )

                        }
                    }, onClick = { onFavorite(!fruit.isFavorite) }
                )
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

        Text(
            modifier = Modifier.padding(start = 20.dp, top = 16.dp, bottom = 12.dp)
                .clickable { onRecipe(-1) }, // todo: fazer a navegação direito
            text = "Receitas",
            style = MaterialTheme.typography.h3
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            AppButton(
                text = {
                    Text(
                        modifier = Modifier.padding(end = 12.dp),
                        text = "Mais sobre ${fruit.name}",
                        style = MaterialTheme.typography.button
                    )
                }, onClick = { onSeeMore(fruit.id) }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFruitScreen(@PreviewParameter(FruitPreviewProvider::class) fruits: List<Fruit>) {
    FruitAppTheme {
        FruitScreen(
            fruit = fruits.first(),
            onSeeMore = { },
            onFavorite = { },
            onRecipe = { },
            onBack = { },
        )
    }
}