package me.brisson.nutrients.ui.nutrients

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.brisson.nutrients.ui.theme.NutrientsTheme

@Composable
fun NutrientsScreen(
    modifier: Modifier = Modifier,
    viewModel: NutrientsViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        if (uiState.loading) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun PreviewNutrientsScreen() {
    NutrientsTheme {
        NutrientsScreen(onBack = { })
    }
}