package com.crestinfosystems_jinay.expancetracker

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.crestinfosystems_jinay.expancetracker.ui.theme.ExpanceTrackerTheme
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExpanceTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    splashScreen()
                }
            }
        }
    }
    @Composable
    private fun splashScreen() {
//    Handler(Looper.getMainLooper()).postDelayed({
//        // Navigate to the main content after the delay
//        navController.popBackStack(ScreenRoute.SplashScreen.route, true)
//        navController.navigate(ScreenRoute.HomeScreen.route)
//    }, 5000)
        val alpha = remember{
            Animatable(0f)
        }
        LaunchedEffect(key1 = true){
            alpha.animateTo(1f, animationSpec = tween(1500))
            delay(2000)
            startActivity(Intent(this@MainActivity,HomeScreen::class.java))
            this@MainActivity.finish()
        }
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
                modifier = Modifier.then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 350.dp)).alpha(alpha.value)
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

}

