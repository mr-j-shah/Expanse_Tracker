package com.crestinfosystems_jinay.expancetracker

sealed class ScreenRoute(val route:String) {
    object HomeScreen : ScreenRoute("HomeScreen")
    object WishList :ScreenRoute("WishListScreen")
    object SplashScreen :ScreenRoute("SplashScreen")
    object AddWishScreen :ScreenRoute("AddWishScreen")
    object ExpenseDetailScreen :ScreenRoute("ExpenseDetailScreen")
    object CategoryViseExpense :ScreenRoute("CategoryViseExpense")
    object FinancialPaletteScreen : ScreenRoute("FinancialPaletteScreen")
    object UserManualScreen : ScreenRoute("UserManualScreen")
    object FAQsScreen : ScreenRoute("FAQsScreen")
    object CustomerSupport : ScreenRoute("CustomerSupport")

}

sealed class RouteBackStackKey(val key:String){
    object Expense : RouteBackStackKey("Expense")
    object Category : RouteBackStackKey("Category")

}