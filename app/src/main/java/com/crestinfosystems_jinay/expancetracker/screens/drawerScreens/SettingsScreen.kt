package com.crestinfosystems_jinay.expancetracker.screens.drawerScreens

import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.Pin
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.ScreenRoute
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar


@Composable
fun SettingsScreen(navController: NavController, viewModel: MainScreenViewModel) {
    val context = LocalContext.current
    val DeleteAllAleartDialog = remember {
        mutableStateOf(
            false

        )
    }
    Scaffold(
        topBar = {
            AppBar(title = "Settings",
                onClicked = { navController.popBackStack() })

        },
        backgroundColor = ColorUtils.primaryBackGroundColor
    ) {
        Column(
            modifier = Modifier
                .padding(it.apply { 10.dp })
                .fillMaxSize()
        ) {
            SettingTile(id = R.drawable.delete, onClick = {
                DeleteAllAleartDialog.value = true
            }, title = "Delete All Expanse")
            SettingTile(id = R.drawable.reset_password, onClick = {

                val intent = Intent(
                    context,
                    Pin::class.java
                )
                intent.putExtra("Screen", "setPin")
                startActivity(context, intent, null)
            }, title = "Change App PIN")
        }

    }
    if (DeleteAllAleartDialog.value) {
        AlertDialog(
            title = {
                Text(
                    text = "Delete All Expenses",
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 16F
                    ).sp
                )
            },
            text = {
                Text(
                    text = "Are you sure you want to delete all expenses? This action cannot be undone.",
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 14F
                    ).sp
                )
            },
            onDismissRequest = { DeleteAllAleartDialog.value = false },
            confirmButton = {
                TextButton(onClick = {
                    DeleteAllAleartDialog.value = false
                    viewModel.deleteAll()
                    navController.navigate(ScreenRoute.HomeScreen.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                }) {
                    Text(
                        text = "Delete All",
                        color = ColorUtils.dismissColor,
                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                            baseSize = 12F
                        ).sp
                    )
                }
            },
            dismissButton = {
                TextButton(onClick = { DeleteAllAleartDialog.value = false }) {
                    Text(
                        text = "Cancel",
                        color = ColorUtils.UPI,
                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                            baseSize = 12F
                        ).sp
                    )
                }
            },
            shape = RoundedCornerShape(10.dp),
        )
    }
}

@Composable
fun SettingTile(onClick: () -> Unit, id: Int, title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(vertical = 10.dp, horizontal = 15.dp)) {
        Image(
            painter = painterResource(id = id),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = ColorUtils.subTextColor)
                .padding(2.dp)
//                .border(width = 0.dp, color = ColorUtils.primaryBackGroundColor)
            ,
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = title,
            color = ColorUtils.textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                baseSize = 16F
            ).sp
        )
    }
}
