package com.example.onboarding.ui.onboarding

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewOnBoardingScreen() {
    FruitAppTheme {
        OnBoardingScreen()
    }
}
