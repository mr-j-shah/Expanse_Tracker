package com.crestinfosystems_jinay.expancetracker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crestinfosystems_jinay.chatapplication.widgets.navigationBarView
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.ScreenRoute
import com.crestinfosystems_jinay.expancetracker.model.MainScreenWidget
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar
import com.crestinfosystems_jinay.expancetracker.widgets.DrawerTile
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(mainScreenVM: MainScreenViewModel, navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AppBar(
                title = "Expense tracker",
                onClicked = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                })
        },
        drawerShape = NavShape(0.dp, 0.85f),
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = ColorUtils.secondaryBakgroundColor)
                    .padding(16.dp)
            ) {

                DrawerTile(id = R.drawable.wish_list, onClick = {
                    navController.navigate(ScreenRoute.WishList.route)
                }, title = "Wish List")
                DrawerTile(id = R.drawable.delete, onClick = {
//                    mainScreenVM.deleteAll()
                }, title = "Delete All Expanse")

            }
        },
        scaffoldState = scaffoldState,
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()

                    .then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 60.dp))
            ) {
                navigationBarView(mainScreenVM)
            }
        },
        backgroundColor = ColorUtils.primaryBackGroundColor
    ) { it ->
        Column(modifier = Modifier.padding(it)) {
            when (mainScreenVM.screen.value.screenState) {
                MainScreenWidget.Dashboard -> DashboardScreen(viewModel = mainScreenVM)
                MainScreenWidget.Add -> AddExpanse(viewModel = mainScreenVM)
                MainScreenWidget.Stetestic -> StatisticScreen(viewModel = mainScreenVM)
            }
        }
    }
}

class NavShape(
    private val widthOffset: Dp,
    private val scale: Float
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Rectangle(
            Rect(
                Offset.Zero,
                Offset(
                    size.width * scale + with(density) { widthOffset.toPx() },
                    size.height
                )
            )
        )
    }
}
