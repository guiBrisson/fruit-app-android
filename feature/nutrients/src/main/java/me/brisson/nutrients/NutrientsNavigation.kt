package me.brisson.nutrients

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import me.brisson.nutrients.ui.nutrients.NutrientsScreen
import me.brisson.nutrients.ui.theme.NutrientsTheme

object NutrientsNavigationRoutes {
    const val NUTRIENTS_ROUTE = "nutrients"
    const val NUTRIENTS_DETAIL_ROUTE = "nutrients_detail"
}

fun NavGraphBuilder.nutrientsNavigation(navController: NavController) {
    navigation(
        startDestination = NutrientsNavigationRoutes.NUTRIENTS_DETAIL_ROUTE,
        route = NutrientsNavigationRoutes.NUTRIENTS_ROUTE
    ) {
        composable("detail") {
            NutrientsTheme {
                NutrientsScreen(
                    onBack = { navController.navigateUp() },
                    onHome = { navController.popBackStack(route = "nutrient", inclusive = true) }
                )
            }
        }
    }
}
