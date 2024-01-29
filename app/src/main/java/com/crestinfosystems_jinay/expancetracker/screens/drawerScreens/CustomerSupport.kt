package com.crestinfosystems_jinay.expancetracker.screens.drawerScreens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar

@Composable
fun CustomerSupport(navController: NavController) {
    val context = LocalContext.current
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = ColorUtils.subTextColor,
                fontFamily = FontFamily.SansSerif,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 14F
                ).sp
            )
        ) {
            append("If you have further questions or encounter issues, please contact developer at ")
        }
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.SemiBold, color = ColorUtils.UPI,
                fontFamily = FontFamily.SansSerif,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 14F
                ).sp
            )
        ) {
            append("shahjinay02@gmail.com")
        }
        withStyle(
            style = SpanStyle(
                color = ColorUtils.subTextColor,
                fontFamily = FontFamily.SansSerif,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 14F
                ).sp
            )
        ) {
            append(" I am here to help!")
        }

    }
    Scaffold(
        topBar = {
            AppBar(title = "Contact Support", onClicked = {
                navController.popBackStack()
            })
        }, backgroundColor = ColorUtils.primaryBackGroundColor
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Jinay Shah",
                color = ColorUtils.DebitCard,
                fontWeight = FontWeight.Bold,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 24F
                ).sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Android Developer",
                color = ColorUtils.textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 16F
                ).sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = annotatedString,
                color = ColorUtils.subTextColor,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 14F
                ).sp,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:shahjinay02@gmail.com")
                    startActivity(context,intent,null)
                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Thank you for choosing the Expense Tracker app. Happy tracking!",
                color = ColorUtils.subTextColor,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 14F
                ).sp,
            )
        }
    }
}