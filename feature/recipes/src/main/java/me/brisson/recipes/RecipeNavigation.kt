package me.brisson.recipes

import androidx.navigation.*
import androidx.navigation.compose.composable
import me.brisson.recipes.ui.recipe.RecipeScreen

object RecipeNavigationRoutes {
    const val RECIPE_ROUTE = "recipe"
    const val RECIPE_DETAIL_ROUTE = "recipe_detail"
}

object RecipeNavigationArgs {
    const val RECIPE_ID_ARGS = "recipe_id"
}

// todo: ver como vai passar o id
fun NavGraphBuilder.recipeNavigation(navController: NavController) {
    navigation(
        startDestination = RecipeNavigationRoutes.RECIPE_DETAIL_ROUTE,
        route = RecipeNavigationRoutes.RECIPE_ROUTE
    ) {
        composable(
            route = RecipeNavigationRoutes.RECIPE_DETAIL_ROUTE,
//            arguments = listOf(navArgument(RecipeNavigationArgs.RECIPE_ID_ARGS) {
//                type = NavType.LongType
//            })
        ) {
            RecipeScreen(onBack = { navController.navigateUp() })
        }
    }
}
