package me.brisson.fruits.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.brisson.fruits.ui.home.HomeScreen
import me.brisson.fruits.ui.nutrient.NutrientScreen
import me.brisson.nutrients.NutrientsNavigationRoutes
import me.brisson.nutrients.nutrientsNavigation

object FruitsNavigationScreens {
    const val HOME_SCREEN = "home"
    const val NUTRIENT_SCREEN = "nutrient"
}

object FruitsNavigationRoutes {
    const val FRUITS_ROUTE = "fruits"
    const val HOME_ROUTE = FruitsNavigationScreens.HOME_SCREEN
    const val NUTRIENT_ROUTE = FruitsNavigationScreens.NUTRIENT_SCREEN
}

fun NavGraphBuilder.fruitsNavigation(navController: NavController) {
    navigation(
        startDestination = FruitsNavigationRoutes.HOME_ROUTE,
        route = FruitsNavigationRoutes.FRUITS_ROUTE
    ) {
        nutrientsNavigation(navController)

        composable(route = FruitsNavigationRoutes.HOME_ROUTE) {
            HomeScreen(onNutrients = { navController.navigate(FruitsNavigationRoutes.NUTRIENT_ROUTE) })
        }

        composable(route = FruitsNavigationRoutes.NUTRIENT_ROUTE) {
            NutrientScreen(onStartRead = { navController.navigate(NutrientsNavigationRoutes.NUTRIENTS_ROUTE) })
        }
    }
}