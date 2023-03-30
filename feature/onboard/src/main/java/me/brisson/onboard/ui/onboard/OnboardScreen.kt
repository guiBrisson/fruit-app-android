package me.brisson.onboard.ui.onboard

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import me.brisson.ui.theme.FruitAppTheme

@Composable
fun OnboardScreen(
    modifier: Modifier = Modifier,
    viewModel: OnBoardingViewModel = hiltViewModel(),
    onLoading: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    OnboardScreen(
        modifier = modifier,
        component = uiState.component,
        onContinue = viewModel::moveToSecondComponent,
        onLoading = onLoading,
        onEnter = {
            viewModel.setUserName(it)
            onLoading()
        }
    )
}

@Composable
internal fun OnboardScreen(
    modifier: Modifier = Modifier,
    component: OnBoardingComponent,
    onContinue: () -> Unit,
    onLoading: () -> Unit,
    onEnter: (userName: String) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://images.unsplash.com/photo-1546548970-71785318a17b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80")
                .crossfade(true)
                .build(),
            //TODO placeholder =  ,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        when (component) {
            OnBoardingComponent.FIRST_COMPONENT -> {
                FirstComponent(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onSkip = onLoading,
                    onContinue = onContinue
                )
            }
            OnBoardingComponent.SECOND_COMPONENT -> {
                SecondComponent(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    onSkip = onLoading,
                    onEnter = onEnter

                )
            }
        }

    }
}

@Preview(showBackground = true, name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewOnBoardingScreen() {
    FruitAppTheme {
        OnboardScreen(
            component = OnBoardingComponent.FIRST_COMPONENT,
            onContinue = {},
            onLoading = {},
            onEnter = {}
        )
    }
}