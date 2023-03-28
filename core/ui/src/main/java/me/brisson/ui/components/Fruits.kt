package me.brisson.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.domain.model.Fruit
import me.brisson.ui.R
import me.brisson.ui.preview_provider.FruitPreviewProvider
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun FruitVerticalItem(
    modifier: Modifier = Modifier,
    fruit: Fruit,
    backgroundColor: Color = Color.White,
    borderStroke: BorderStroke = BorderStroke(width = 1.dp, color = Color.Black),
    offset: Dp = 2.dp,
    onFavorite: (Boolean) -> Unit
) {
    Box(modifier = Modifier.height(IntrinsicSize.Min)) {
        Box(
            modifier = modifier
                .offset(x = offset, y = offset)
                .matchParentSize()
                .background(backgroundColor)
                .border(borderStroke)
        )
        Row(
            modifier = modifier
                .defaultMinSize(minHeight = 70.dp)
                .fillMaxWidth()
                .background(backgroundColor)
                .border(borderStroke),

            ) {
            fruit.imageUrl?.let { url ->
                AsyncImage(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(110.dp)
                        .drawBehind {
                            val x = size.width
                            val maxY = size.height
                            val stroke = borderStroke.width.toPx() * 2

                            drawLine(
                                brush = borderStroke.brush,
                                start = Offset(x, 0f),
                                end = Offset(x, maxY),
                                strokeWidth = stroke
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(url)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = fruit.name,
                    style = MaterialTheme.typography.h4
                )
                Text(
                    modifier = Modifier.padding(top = 0.dp),
                    text = fruit.summary,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            val painter = if (fruit.isFavorite) {
                painterResource(id = R.drawable.ic_heart_filled)
            } else {
                painterResource(id = R.drawable.ic_heart)
            }


            IconButton(
                modifier = Modifier.padding(top = 2.dp, end = 2.dp),
                onClick = { onFavorite(!fruit.isFavorite) }
            ) {
                Icon(
                    painter = painter,
                    contentDescription = null,
                    tint= Color.Unspecified
                )
            }
        }
    }
}

@Composable
fun FruitCardItem(
    modifier: Modifier = Modifier,
    fruit: Fruit,
    backgroundColor: Color = Color.White,
    borderStroke: BorderStroke = BorderStroke(width = 1.dp, color = Color.Black),
    offset: Dp = 2.dp,
    onFavorite: (Boolean) -> Unit
) {
    Box(modifier = Modifier) {
        Box(
            modifier = modifier
                .offset(x = offset, y = offset)
                .matchParentSize()
                .background(backgroundColor)
                .border(borderStroke)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .border(borderStroke),
        ) {
            fruit.imageUrl?.let { url ->
                AsyncImage(
                    modifier = Modifier
                        .height(90.dp)
                        .fillMaxWidth()
                        .drawBehind {
                            val maxX = size.width
                            val y = size.height
                            val stroke = borderStroke.width.toPx() * 2

                            drawLine(
                                brush = borderStroke.brush,
                                start = Offset(0f, y),
                                end = Offset(maxX, y),
                                strokeWidth = stroke
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(url)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 12.dp,
                        bottom = 16.dp
                    )
                ) {
                    Text(
                        text = fruit.name,
                        style = MaterialTheme.typography.h4
                    )
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = fruit.summary,
                        style = MaterialTheme.typography.subtitle2,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                val painter = if (fruit.isFavorite) {
                    painterResource(id = R.drawable.ic_heart_filled)
                } else {
                    painterResource(id = R.drawable.ic_heart)
                }

                IconButton(
                    modifier = Modifier
                        .padding(0.dp)
                        .align(Alignment.TopEnd),
                    onClick = { onFavorite(!fruit.isFavorite) }
                ) {
                    Icon(
                        painter = painter,
                        contentDescription = null,
                        tint= Color.Unspecified
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewFruitVerticalItem(@PreviewParameter(FruitPreviewProvider::class) fruit: Fruit) {
    FruitAppTheme {
        FruitVerticalItem(fruit = fruit, onFavorite = { })
    }
}