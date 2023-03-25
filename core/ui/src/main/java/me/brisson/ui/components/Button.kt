package me.brisson.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    accentColor: Color = MaterialTheme.colors.onBackground,
) {
    Row(
        modifier = modifier
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp) )
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick?.let { it() } }
            .padding(horizontal = 16.dp, vertical = 14.dp)
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        text()
        trailingIcon()
    }
}

@Preview
@Composable
fun PreviewAppButton() {
    FruitAppTheme {
        AppButton(modifier = Modifier.width(150.dp), text = { Text(text = "Next") })
    }
}