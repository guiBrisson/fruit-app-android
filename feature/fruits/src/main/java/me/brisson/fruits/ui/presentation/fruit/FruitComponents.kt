package me.brisson.fruits.ui.presentation.fruit

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable
fun FruitIconButton(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit = {
        Icon(
            tint = Color.White,
            imageVector = Icons.Rounded.ArrowBackIosNew,
            contentDescription = null
        )
    },
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .clip(CircleShape)
            .background(Color.Black.copy(alpha = 0.4f)),
        onClick = onClick
    ) {
        icon()
    }
}