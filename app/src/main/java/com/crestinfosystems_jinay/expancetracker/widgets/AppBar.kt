package com.crestinfosystems_jinay.expancetracker.widgets

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppBar(
    title: String, onClicked: () -> Unit = {},
) {
    val navigationIcon: (@Composable
        () -> Unit) = {
        IconButton(onClick = {
            onClicked()
        }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
    if (!title.contains("Expense tracker")) {
        TopAppBar(
            navigationIcon = {
                navigationIcon()
            },
            title = {
                androidx.compose.material3.Text(
                    text = title,
                    color = ColorUtils.textColor,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 24F
                    ).sp,
                    fontWeight = FontWeight.SemiBold
                )
            },
            elevation = 4.dp,
            backgroundColor = ColorUtils.primaryBackGroundColor

        )
    }
    else{
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = {
                    onClicked()
                }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            },
            title = {
                androidx.compose.material3.Text(
                    text = title,
                    color = ColorUtils.textColor,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 24F
                    ).sp,
                    fontWeight = FontWeight.SemiBold
                )
            },
            elevation = 4.dp,
            backgroundColor = ColorUtils.primaryBackGroundColor

        )
    }


}