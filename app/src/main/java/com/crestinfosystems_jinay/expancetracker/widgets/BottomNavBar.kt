package com.crestinfosystems_jinay.chatapplication.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.model.MainScreenWidget
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils


import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel

@Composable
fun navigationBarView(mainScreenVM: MainScreenViewModel) {
    val iconWidth :Int = 26
    val iconHeight :Int = 26
    val dorColor:Color = ColorUtils.textColor
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 60.dp))
    ) {
        Box(modifier = Modifier.clickable {
            mainScreenVM.changeScreen(MainScreenWidget.Dashboard)
        }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null,
                    tint = ColorUtils.subTextColor,
                    modifier = Modifier.then(
                        ComposeUtils.modifyDimensionsBasedOnScreenSize(
                            baseWidth = iconWidth.dp,
                            baseHeight = iconHeight.dp
                        )
                    )
                )
                if(mainScreenVM.screen.value.screenState == MainScreenWidget.Dashboard){
                    Icon(
                        painter = painterResource(id = R.drawable.dot),
                        contentDescription = null,
                        tint = dorColor,
                        modifier = Modifier.then(
                            ComposeUtils.modifyDimensionsBasedOnScreenSize(
                                baseWidth = 16.dp,
                                baseHeight = 16.dp
                            )
                        )
                    )
                }
            }
        }

        Box(modifier = Modifier.clickable {
            mainScreenVM.changeScreen(MainScreenWidget.Add)
        }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null,
                    tint = ColorUtils.subTextColor,
                    modifier = Modifier.then(
                        ComposeUtils.modifyDimensionsBasedOnScreenSize(
                            baseWidth = iconWidth.dp,
                            baseHeight = iconHeight.dp
                        )
                    )
                )
                if(mainScreenVM.screen.value.screenState == MainScreenWidget.Add){
                    Icon(
                        painter = painterResource(id = R.drawable.dot),
                        contentDescription = null,
                        tint = dorColor,
                        modifier = Modifier.then(
                            ComposeUtils.modifyDimensionsBasedOnScreenSize(
                                baseWidth = 16.dp,
                                baseHeight = 16.dp
                            )
                        )
                    )
                }
            }
        }
        Box(modifier = Modifier.clickable {
            mainScreenVM.changeScreen(MainScreenWidget.Stetestic)
        }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.trend),
                    contentDescription = null,
                    tint = ColorUtils.subTextColor,
                    modifier = Modifier.then(
                        ComposeUtils.modifyDimensionsBasedOnScreenSize(
                            baseWidth = iconWidth.dp,
                            baseHeight = iconHeight.dp
                        )
                    )
                )
                if(mainScreenVM.screen.value.screenState == MainScreenWidget.Stetestic){
                    Icon(
                        painter = painterResource(id = R.drawable.dot),
                        contentDescription = null,
                        tint = dorColor,
                        modifier = Modifier.then(
                            ComposeUtils.modifyDimensionsBasedOnScreenSize(
                                baseWidth = 16.dp,
                                baseHeight = 16.dp
                            )
                        )
                    )
                }
            }
        }
    }
}
