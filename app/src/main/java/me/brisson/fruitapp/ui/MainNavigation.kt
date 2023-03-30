package me.brisson.fruitapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import me.brisson.onboard.ui.onboardNavigation
import me.brisson.fruits.ui.FruitsNavigationRoutes
import me.brisson.fruits.ui.fruitsNavigation

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = FruitsNavigationRoutes.FRUITS_ROUTE,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        onboardNavigation(navController)
        fruitsNavigation(navController)
    }

}
