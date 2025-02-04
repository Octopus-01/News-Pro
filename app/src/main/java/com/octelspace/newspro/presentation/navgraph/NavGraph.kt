package com.octelspace.newspro.presentation.navgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.ActivityNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.octelspace.newspro.presentation.onboarding.OnBoardingScreen
import com.octelspace.newspro.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination ){
        navigation(
            route = Routs.AppStartNavigation.routs,
            startDestination = Routs.OnBoardingScreen.routs
        ){
            composable(
                route = Routs.OnBoardingScreen.routs
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Routs.NewsNavigation.routs,
            startDestination = Routs.NewsNavigatorScreen.routs
        ){
            composable(
                route = Routs.NewsNavigatorScreen.routs
            ){
                Text(text = "NewsNavigatorScreen")
            }
        }
    }
}