package com.crestinfosystems_jinay.expancetracker

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.crestinfosystems_jinay.expancetracker.data.Expanse
import com.crestinfosystems_jinay.expancetracker.model.PaymentMode
import com.crestinfosystems_jinay.expancetracker.screens.WishList.AddUpdataeDetail
import com.crestinfosystems_jinay.expancetracker.screens.Expense.CategoryExpenseList
import com.crestinfosystems_jinay.expancetracker.screens.Expense.ExpanseDetailScreen
import com.crestinfosystems_jinay.expancetracker.screens.drawerScreens.FAQs
import com.crestinfosystems_jinay.expancetracker.screens.drawerScreens.FinancialPalette
import com.crestinfosystems_jinay.expancetracker.screens.HomeScreen
import com.crestinfosystems_jinay.expancetracker.screens.drawerScreens.UserManual
import com.crestinfosystems_jinay.expancetracker.screens.WishList.WishListScreen
import com.crestinfosystems_jinay.expancetracker.screens.drawerScreens.CustomerSupport
import com.crestinfosystems_jinay.expancetracker.screens.drawerScreens.SettingsScreen

import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel

@Composable
fun Navigation() {
    val viewModel: MainScreenViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = ScreenRoute.HomeScreen.route,
        enterTransition = {
            // you can change whatever you want transition
            EnterTransition.None
        },
        exitTransition = {
            // you can change whatever you want transition
            ExitTransition.None
        }) {
        composable(route = ScreenRoute.HomeScreen.route) {
            HomeScreen(viewModel, navController = navController)
        }
        composable(route = ScreenRoute.WishList.route) {
            WishListScreen(navController = navController, viewModel = viewModel)
        }
        composable(ScreenRoute.AddWishScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.LongType
                    defaultValue = 0L
                    nullable = false
                }
            )
        ) {
            val id = if (it.arguments != null) it.arguments!!.getLong("id") else 0L
            AddUpdataeDetail(id = id, navController, viewModel)
        }
        composable(ScreenRoute.ExpenseDetailScreen.route) {
            val expanse: Expanse =
                navController.previousBackStackEntry?.savedStateHandle?.get(RouteBackStackKey.Expense.key)
                    ?: Expanse(
                        id = 0,
                        title = "Null",
                        des = "Null",
                        0F,
                        date = "null",
                        category = "", mode = PaymentMode.Cash.name
                    )
            ExpanseDetailScreen(
                expanse = expanse,
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(ScreenRoute.CategoryViseExpense.route + "/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = false
                }
            )) {
            val category = if (it.arguments != null) it.arguments!!.getString("category") else ""
//            val category: String =
//                navController.previousBackStackEntry?.savedStateHandle?.get(RouteBackStackKey.Category.key)
//                    ?: ""
            CategoryExpenseList(
                viewModel = viewModel,
                category = category?:"",
                navController = navController
            )
        }
        composable(ScreenRoute.FinancialPaletteScreen.route){
            FinancialPalette(navController = navController)
        }
        composable(ScreenRoute.UserManualScreen.route){
            UserManual(navController = navController)
        }
        composable(ScreenRoute.FAQsScreen.route){
            FAQs(navController = navController)
        }
        composable(ScreenRoute.CustomerSupport.route){
            CustomerSupport(navController = navController)
        }
        composable(ScreenRoute.Settings.route){
            SettingsScreen(navController = navController,viewModel = viewModel)
        }
    }
}