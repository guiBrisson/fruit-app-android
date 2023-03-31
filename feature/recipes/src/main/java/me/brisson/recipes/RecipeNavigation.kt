package me.brisson.recipes

import androidx.navigation.*
import androidx.navigation.compose.composable
import me.brisson.recipes.ui.recipe.RecipeScreen

object RecipeNavigationScreen {
    const val RECIPE_SCREEN = "recipe"
}

object RecipeNavigationRoutes {
    const val RECIPE_ROUTE =
        "${RecipeNavigationScreen.RECIPE_SCREEN}/{${RecipeNavigationArgs.RECIPE_ID_ARGS}}"
}

object RecipeNavigationArgs {
    const val RECIPE_ID_ARGS = "recipe_id"
}

fun NavGraphBuilder.recipeNavigation(navController: NavController) {
    composable(
        route = RecipeNavigationRoutes.RECIPE_ROUTE,
        arguments = listOf(navArgument(RecipeNavigationArgs.RECIPE_ID_ARGS) {
            type = NavType.LongType
        })
    ) {
        RecipeScreen(onBack = { navController.navigateUp() })
    }
}
