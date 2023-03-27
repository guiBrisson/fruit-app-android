package me.brisson.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.brisson.ui.R

val gothicA1 = FontFamily(
    Font(R.font.gothic_a1_thin, weight = FontWeight.Thin),
    Font(R.font.gothic_a1_extra_light, weight = FontWeight.ExtraLight),
    Font(R.font.gothic_a1_light, weight = FontWeight.Light),
    Font(R.font.gothic_a1_regular, weight = FontWeight.Normal),
    Font(R.font.gothic_a1_medium, weight = FontWeight.Medium),
    Font(R.font.gothic_a1_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.gothic_a1_bold, weight = FontWeight.Bold),
    Font(R.font.gothic_a1_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.gothic_a1_black, weight = FontWeight.Black),
)

val Typography = Typography(
    defaultFontFamily = gothicA1,
    body1 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.Black,
        fontSize = 38.sp,
        letterSpacing = (-2).sp
    ),
    h2 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
    ),
    h3 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    button = TextStyle(
        fontFamily = gothicA1,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
)