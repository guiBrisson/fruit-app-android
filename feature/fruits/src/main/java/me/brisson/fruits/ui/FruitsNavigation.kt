package me.brisson.fruits.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.brisson.fruits.ui.home.HomeScreen

object FruitsNavigationScreens {
    const val HOME_SCREEN = "home"
}

object FruitsNavigationRoutes {
    const val FRUITS_ROUTE = "fruits"
    const val HOME_ROUTE = FruitsNavigationScreens.HOME_SCREEN
}

fun NavGraphBuilder.fruitsNavigation(navController: NavController) {
    navigation(
        startDestination = FruitsNavigationRoutes.HOME_ROUTE,
        route = FruitsNavigationRoutes.FRUITS_ROUTE
    ) {
        composable(route = FruitsNavigationRoutes.HOME_ROUTE) {
            HomeScreen()
        }
    }
}