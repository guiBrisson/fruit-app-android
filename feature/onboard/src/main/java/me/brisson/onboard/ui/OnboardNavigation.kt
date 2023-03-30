package me.brisson.onboard.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.brisson.onboard.ui.loading.LoadingScreen
import me.brisson.onboard.ui.onboard.OnboardScreen


object OnboardNavigationRoutes {
    const val ONBOARD_ROUTE = "onboard"
    const val ONBOARD_SCREEN_ROUTE = "onboard_screen"
    const val LOADING_ROUTE = "loading"
}

fun NavGraphBuilder.onboardNavigation(navController: NavController) {
    navigation(
        startDestination = OnboardNavigationRoutes.ONBOARD_SCREEN_ROUTE,
        route = OnboardNavigationRoutes.ONBOARD_ROUTE
    ) {
        composable(route = OnboardNavigationRoutes.ONBOARD_SCREEN_ROUTE) {
            OnboardScreen(onLoading = {
                navController.navigate(OnboardNavigationRoutes.LOADING_ROUTE)
            })
        }
        composable(route = OnboardNavigationRoutes.LOADING_ROUTE) {
            LoadingScreen()
        }
    }
}