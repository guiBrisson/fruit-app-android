package me.brisson.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.domain.model.Fruit

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
                                brush = borderStroke.brush ,
                                start = Offset(x, 0f),
                                end = Offset(x, maxY),
                                strokeWidth = stroke
                            )

                            drawLine(
                                color = Color.Black,
                                strokeWidth = 1f,
                                start = Offset(x = 1f, y = 1f),
                                end = Offset(x = 1f, y = 0f)
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

            val imageVector = if (fruit.isFavorite) {
                Icons.Rounded.Favorite
            } else {
                Icons.Rounded.FavoriteBorder
            }

            val color = if (fruit.isFavorite) {
                Color.Red
            } else {
                Color.Black
            }

            IconButton(onClick = { onFavorite(!fruit.isFavorite) }) {
                Icon(
                    modifier = Modifier.padding(top = 2.dp, end = 2.dp),
                    imageVector = imageVector,
                    contentDescription = null,
                    tint = color
                )
            }
        }
    }
}
