package com.example.onboarding.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.onboarding.ui.loading.LoadingScreen
import com.example.onboarding.ui.onboarding.OnBoardingScreen


object OnBoardingNavigationRoutes {
    const val ONBOARDING_ROUTE = "onboarding"
    const val ONBOARDDING_SCREEN_ROUTE = "onboarding_screen"
    const val LOADING_ROUTE = "loading"
}

fun NavGraphBuilder.onBoardingNavigation(navController: NavController){
    navigation(startDestination = OnBoardingNavigationRoutes.ONBOARDDING_SCREEN_ROUTE, route = OnBoardingNavigationRoutes.ONBOARDING_ROUTE){
        composable(route = OnBoardingNavigationRoutes.ONBOARDDING_SCREEN_ROUTE){
            OnBoardingScreen(onLoading = {
                navController.navigate(OnBoardingNavigationRoutes.LOADING_ROUTE)
            })
        }
        composable(route = OnBoardingNavigationRoutes.LOADING_ROUTE){
            LoadingScreen()
        }
    }
}