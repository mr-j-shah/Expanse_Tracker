package com.crestinfosystems_jinay.expancetracker

sealed class ScreenRoute(val route:String) {
    object HomeScreen : ScreenRoute("HomeScreen")
    object WishList :ScreenRoute("WishListScreen")
    object SplashScreen :ScreenRoute("SplashScreen")
    object AddWishScreen :ScreenRoute("AddWishScreen")
    object ExpenseDetailScreen :ScreenRoute("ExpenseDetailScreen")

}

sealed class RouteBackStackKey(val key:String){
    object Expense : RouteBackStackKey("Expense")
}