package me.brisson.nutrients.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorsPalette = darkColors(
    primary = PrimaryDark,
    onBackground = OnBackGroundDark,
    background = BackGroundDark,
    surface = SurfaceDark
)

private val LightColorsPalette = lightColors(
    primary = PrimaryLight,
    onBackground = OnBackGroundLight,
    background = BackGroundLight,
    surface = SurfaceLight
)

@Composable
fun NutrientsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorsPalette
    } else {
        LightColorsPalette
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}