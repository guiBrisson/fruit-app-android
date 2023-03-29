package me.brisson.fruits.ui.fruit_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.brisson.ui.theme.FruitAppTheme
import me.brisson.ui.theme.gothicA1

@Composable
fun MonthTag(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Brush = SolidColor(Color.White),
    backgroundColor: Brush = SolidColor(Color.Black),
    borderColor: Brush = SolidColor(Color.Black),
    shape: Shape = CircleShape,
) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .border(width = 1.dp, borderColor, shape)
            .padding(horizontal = 14.dp, vertical = 2.dp)
    ) {
        Text(
            modifier = Modifier
                .graphicsLayer(alpha = 0.99f)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(textColor, blendMode = BlendMode.SrcAtop)
                    }
                },
            text = text,
            fontWeight = FontWeight.Medium,
            fontFamily = gothicA1
        )
    }
}

@Preview
@Composable
fun PreviewMonthTag() {
    FruitAppTheme {
        MonthTag(text = "Janeiro")
    }
}