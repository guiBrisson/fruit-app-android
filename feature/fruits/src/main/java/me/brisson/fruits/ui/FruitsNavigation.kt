package me.brisson.fruits.ui

import androidx.navigation.*
import androidx.navigation.compose.composable
import me.brisson.fruits.ui.presentation.crop_season.CropSeasonScreen
import me.brisson.fruits.ui.presentation.fruit.FruitScreen
import me.brisson.fruits.ui.presentation.fruit_detail.FruitDetailScreen
import me.brisson.fruits.ui.presentation.home.HomeScreen
import me.brisson.fruits.ui.presentation.month.MonthScreen
import me.brisson.fruits.ui.presentation.nutrient.NutrientScreen
import me.brisson.nutrients.NutrientsNavigationRoutes
import me.brisson.nutrients.nutrientsNavigation
import me.brisson.recipes.RecipeNavigationScreen
import me.brisson.recipes.recipeNavigation

object FruitsNavigationScreens {
    const val HOME_SCREEN = "home"
    const val NUTRIENT_SCREEN = "nutrient"
    const val CROP_SCREEN = "crop"
    const val MONTH_SCREEN = "month"
    const val FRUIT_SCREEN = "fruit"
    const val FRUIT_DETAIL_SCREEN = "fruit_detail"
}

object FruitsNavigationArgs {
    const val MONTH_NAME_ARGS = "month_name"
    const val FRUIT_ID_ARGS = "fruit_id"
}

object FruitsNavigationRoutes {
    const val FRUITS_ROUTE = "fruits"
    const val HOME_ROUTE = FruitsNavigationScreens.HOME_SCREEN
    const val NUTRIENT_ROUTE = FruitsNavigationScreens.NUTRIENT_SCREEN
    const val CROP_ROUTE = FruitsNavigationScreens.CROP_SCREEN
    const val MONTH_ROUTE =
        "${FruitsNavigationScreens.MONTH_SCREEN}/{${FruitsNavigationArgs.MONTH_NAME_ARGS}}"
    const val FRUIT_ROUTE =
        "${FruitsNavigationScreens.FRUIT_SCREEN}/{${FruitsNavigationArgs.FRUIT_ID_ARGS}}"
    const val FRUIT_DETAIL_ROUTE =
        "${FruitsNavigationScreens.FRUIT_DETAIL_SCREEN}/{${FruitsNavigationArgs.FRUIT_ID_ARGS}}"
}

fun NavGraphBuilder.fruitsNavigation(navController: NavController) {
    navigation(
        startDestination = FruitsNavigationRoutes.HOME_ROUTE,
        route = FruitsNavigationRoutes.FRUITS_ROUTE
    ) {
        nutrientsNavigation(navController)
        recipeNavigation(navController)

        composable(route = FruitsNavigationRoutes.HOME_ROUTE) {
            HomeScreen(
                onFruit = { fruitId ->
                    val route = "${FruitsNavigationScreens.FRUIT_SCREEN}/$fruitId"
                    navController.navigate(route)
                },
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
                onFruit = { fruitId ->
                    val route = "${FruitsNavigationScreens.FRUIT_SCREEN}/$fruitId"
                    navController.navigate(route)
                },
                onBack = { navController.navigateUp() }
            )
        }

        composable(
            route = FruitsNavigationRoutes.FRUIT_ROUTE,
            arguments = listOf(navArgument(FruitsNavigationArgs.FRUIT_ID_ARGS) {
                type = NavType.LongType
            })
        ) {
            FruitScreen(
                onSeeMore = { fruitId ->
                    val route = "${FruitsNavigationScreens.FRUIT_DETAIL_SCREEN}/$fruitId"
                    navController.navigate(route)
                },
                onRecipe = { recipeId ->
                    val route = "${RecipeNavigationScreen.RECIPE_SCREEN}/$recipeId"
                    navController.navigate(route)
                },
                onBack = { navController.navigateUp() }
            )
        }

        composable(
            route = FruitsNavigationRoutes.FRUIT_DETAIL_ROUTE,
            arguments = listOf(navArgument(FruitsNavigationArgs.FRUIT_ID_ARGS) {
                type = NavType.LongType
            })
        ) {
            FruitDetailScreen(
                onBack = { navController.navigateUp() }
            )
        }

    }
}