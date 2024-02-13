package com.crestinfosystems_jinay.expancetracker

import SetPinScreen
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.crestinfosystems_jinay.expancetracker.AppPIN.PinLockScreen
import com.crestinfosystems_jinay.expancetracker.ui.theme.ExpanceTrackerTheme


class Pin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val initScreen = intent.getStringExtra("Screen")?:"enterPin"
        setContent {
            ExpanceTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = initScreen,
                        enterTransition = {
                            // you can change whatever you want transition
                            EnterTransition.None
                        },
                        exitTransition = {
                            // you can change whatever you want transition
                            ExitTransition.None
                        }) {
                        composable("enterPin") {
                            PinLockScreen(navController = navController, doItLater = {
                                startActivity(Intent(this@Pin, HomeScreen::class.java))
                                this@Pin.finish()
                            })
                        }
                        composable("setPin") {
                            SetPinScreen(navController = navController, nextScreen = {
                                startActivity(Intent(this@Pin, HomeScreen::class.java))
                                this@Pin.finish()
                            })
                        }
                    }

                }
            }
        }
    }


}



