package me.brisson.fruits.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.backgroundGreen

@Composable
fun HomeItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    backgroundColor: Color = backgroundGreen,
    offset: Dp = 2.dp,
    shape: Shape = RoundedCornerShape(4.dp)
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = offset, y = offset)
                .clip(shape)
                .background(MaterialTheme.colors.onBackground)
        )

        Column(
            modifier = modifier
                .clip(shape)
                .background(backgroundColor)
                .padding(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier.padding(top = 2.dp),
                text = subTitle,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeItem() {
    FruitAppTheme {
        HomeItem(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            title = "Safra das frutas",
            subTitle = "Aposte nas frutas da estação para garantir tudo o que elas podem oferecer o seu organismo"
        )
    }
}