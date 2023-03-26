package me.brisson.fruitapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import me.brisson.nutrients.NutrientsNavigationRoutes
import me.brisson.nutrients.nutrientsNavigation

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NutrientsNavigationRoutes.NUTRIENTS_ROUTE
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        nutrientsNavigation(navController)
    }

}
