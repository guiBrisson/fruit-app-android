package me.brisson.fruits.ui

import androidx.navigation.*
import androidx.navigation.compose.composable
import me.brisson.fruits.ui.crop_season.CropSeasonScreen
import me.brisson.fruits.ui.home.HomeScreen
import me.brisson.fruits.ui.month.MonthScreen
import me.brisson.fruits.ui.nutrient.NutrientScreen
import me.brisson.nutrients.NutrientsNavigationRoutes
import me.brisson.nutrients.nutrientsNavigation

object FruitsNavigationScreens {
    const val HOME_SCREEN = "home"
    const val NUTRIENT_SCREEN = "nutrient"
    const val CROP_SCREEN = "crop"
    const val MONTH_SCREEN = "month_screen"
}

object FruitsNavigationArgs {
    const val MONTH_NAME_ARGS = "month_name"
}

object FruitsNavigationRoutes {
    const val FRUITS_ROUTE = "fruits"
    const val HOME_ROUTE = FruitsNavigationScreens.HOME_SCREEN
    const val NUTRIENT_ROUTE = FruitsNavigationScreens.NUTRIENT_SCREEN
    const val CROP_ROUTE = FruitsNavigationScreens.CROP_SCREEN
    const val MONTH_ROUTE =
        "${FruitsNavigationScreens.MONTH_SCREEN}/{${FruitsNavigationArgs.MONTH_NAME_ARGS}}"
}

fun NavGraphBuilder.fruitsNavigation(navController: NavController) {
    navigation(
        startDestination = FruitsNavigationRoutes.HOME_ROUTE,
        route = FruitsNavigationRoutes.FRUITS_ROUTE
    ) {
        nutrientsNavigation(navController)

        composable(route = FruitsNavigationRoutes.HOME_ROUTE) {
            HomeScreen(
                onNutrients = { navController.navigate(FruitsNavigationRoutes.NUTRIENT_ROUTE) },
                onCrops = { navController.navigate(route = FruitsNavigationRoutes.CROP_ROUTE) }
            )
        }

        composable(route = FruitsNavigationRoutes.NUTRIENT_ROUTE) {
            NutrientScreen(
                onStartRead = { navController.navigate(NutrientsNavigationRoutes.NUTRIENTS_ROUTE) },
                onBack = { navController.navigateUp() }
            )
        }

        composable(route = FruitsNavigationRoutes.CROP_ROUTE) {
            CropSeasonScreen(
                onMonth = { monthName ->
                    val route = "${FruitsNavigationScreens.MONTH_SCREEN}/$monthName"
                    navController.navigate(route)
                },
                onBack = { navController.navigateUp() }
            )
        }

        composable(
            route = FruitsNavigationRoutes.MONTH_ROUTE,
            arguments = listOf(navArgument(FruitsNavigationArgs.MONTH_NAME_ARGS) {
                type = NavType.StringType
            })
        ) {
            MonthScreen(
                onFruit = { /* TODO */ },
                onBack = { navController.navigateUp() }
            )
        }
    }
}