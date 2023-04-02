package me.brisson.onboard.ui.loading

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.brisson.ui.theme.gothicA1

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "só um segundo",
                fontFamily = gothicA1,
                fontSize = 26.sp,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                text = "anotando as receitinhas pra você",
                fontFamily = gothicA1,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(34.dp),
                color = Color.Black,
                backgroundColor = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true, name = "Light", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewLoadingScreen() {
    LoadingScreen()
}