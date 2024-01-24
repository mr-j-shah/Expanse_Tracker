package com.crestinfosystems_jinay.expancetracker

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crestinfosystems_jinay.expancetracker.screens.HomeScreen
import com.crestinfosystems_jinay.expancetracker.screens.splashScreen
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel

@Composable
fun Navigation() {
    val viewModel : MainScreenViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoute.HomeScreen.route){
        composable(route = ScreenRoute.SplashScreen.route){
            splashScreen(navController = navController)
        }
        composable(route = ScreenRoute.HomeScreen.route){
            HomeScreen(viewModel)
        }
    }
}