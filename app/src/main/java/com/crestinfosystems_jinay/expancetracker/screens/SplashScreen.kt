package com.crestinfosystems_jinay.expancetracker.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.ScreenRoute
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils

@Composable
fun splashScreen(navController: NavHostController) {
    Handler(Looper.getMainLooper()).postDelayed({
        // Navigate to the main content after the delay
        navController.popBackStack(ScreenRoute.SplashScreen.route, true)
        navController.navigate(ScreenRoute.HomeScreen.route)
    }, 5000)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ColorUtils.SplashScreenBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_screen_with_back),
            contentDescription = null,
            modifier = Modifier.then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 350.dp))
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            softWrap = true,
            text = "Spend Smarter",
            color = ColorUtils.SplashScreenText,
            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                baseSize = 36f
            ).sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )
        Text(
            softWrap = true,
            text = "Save more",
            color = ColorUtils.SplashScreenText,
            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                baseSize = 36f
            ).sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,

            )
    }
}

