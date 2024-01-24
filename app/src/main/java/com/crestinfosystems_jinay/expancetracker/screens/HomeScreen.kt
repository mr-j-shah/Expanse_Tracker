package com.crestinfosystems_jinay.expancetracker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.crestinfosystems_jinay.chatapplication.widgets.navigationBarView
import com.crestinfosystems_jinay.expancetracker.model.MainScreenWidget
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar

@Composable
fun HomeScreen(mainScreenVM: MainScreenViewModel) {
    Scaffold(
        topBar = {
            AppBar(title = "Expense tracker") {
            }

        },
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
            when(mainScreenVM.screen.value.screenState){
                MainScreenWidget.Dashboard-> DashboardScreen(viewModel = mainScreenVM)
                MainScreenWidget.Add -> AddExpanse(viewModel = mainScreenVM)
                MainScreenWidget.Stetestic -> StatisticScreen(viewModel = mainScreenVM)
            }
        }
    }
}