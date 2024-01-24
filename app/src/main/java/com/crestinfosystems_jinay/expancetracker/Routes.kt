package com.crestinfosystems_jinay.expancetracker

sealed class ScreenRoute(val route:String) {
    object HomeScreen : ScreenRoute("HomeScreen")
    object AddScreen :ScreenRoute("AddScreen")
    object SplashScreen :ScreenRoute("SplashScreen")

}