package me.brisson.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: @Composable () -> Unit,
    onClick: (() -> Unit)? = null,
    trailingIcon: @Composable () -> Unit = {
        Icon(imageVector = Icons.Rounded.ArrowForward, contentDescription = null)
    },
    backgroundColor: Color = MaterialTheme.colors.background,
    borderColor: Color = MaterialTheme.colors.onBackground,
    accentColor: Color = MaterialTheme.colors.onBackground,
    offset: Dp = 2.dp
) {
    val shape = RoundedCornerShape(8.dp)
    Box {
        Box(
            modifier = modifier
                .matchParentSize()
                .offset(x = offset, y = offset)
                .clip(shape)
                .background(accentColor)
        )
        Row(
            modifier = modifier
                .height(52.dp)
                .border(width = 1.dp, color =  borderColor, shape = shape)
                .clip(shape)
                .background(backgroundColor)
                .clickable { onClick?.let { it() } }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            text()
            trailingIcon()
        }

    }
}


@Preview
@Composable
fun PreviewAppButton() {
    FruitAppTheme {
        AppButton(modifier = Modifier.width(150.dp), text = { Text(text = "Next") })
    }
}