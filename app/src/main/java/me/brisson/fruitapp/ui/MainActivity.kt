package me.brisson.fruitapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import me.brisson.domain.repository.SharedPref
import me.brisson.fruits.ui.FruitsNavigationRoutes
import me.brisson.onboard.ui.OnboardNavigationRoutes
import me.brisson.ui.theme.FruitAppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FruitAppTheme {
                val startDestination = if (sharedPref.hasLoggedBefore()) {
                    FruitsNavigationRoutes.FRUITS_ROUTE
                } else {
                    OnboardNavigationRoutes.ONBOARD_ROUTE
                }

                MainNavigation(startDestination = startDestination)
            }
        }
    }
}

