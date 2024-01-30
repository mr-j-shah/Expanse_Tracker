package com.crestinfosystems_jinay.expancetracker.AppPIN

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import kotlinx.coroutines.delay

val pinSize = 4


@Composable
fun PinLockScreen(navController: NavController, doItLater: () -> Unit = {}) {
    val inputPin = remember { mutableStateListOf<Int>() }
    val error = remember { mutableStateOf<String>("") }
    val showSuccess = remember { mutableStateOf(false) }
    val context = LocalContext.current

    val preferencesManager = remember { PreferencesManager(context) }
//        preferencesManager.saveData("pin","")
    val data = remember { mutableStateOf(preferencesManager.getData("pin", "")) }


    if (data.value == "") {
        BottomSheet(doItLater = {
            doItLater()

        }, onDismiss = {}, setPin = {
            navController.navigate("setPin")
        })
    }
    if (inputPin.size == 4) {
        LaunchedEffect(true) {
            delay(300)
            if (inputPin.joinToString("") == data.value) {
                showSuccess.value = true
                error.value = ""
            } else {
                inputPin.clear()
                error.value = "Wrong pin, Please retry!"
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorUtils.primaryBackGroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(50.dp))

                Image(
                    painter = painterResource(id = R.drawable.splash_screen_with_back),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )

                Text(
                    text = "Enter pin to unlock",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(16.dp),
                    color = ColorUtils.textColor
                )

                Spacer(modifier = Modifier.height(30.dp))

                if (showSuccess.value) {
                    LottieLoadingView(
                        context = context,
                        file = "success.json",
                        iterations = 1,
                        modifier = Modifier.size(100.dp)
                    )
                    LaunchedEffect(key1 = true) {
                        delay(2000)
                        doItLater()
                    }
                } else {
                    Row {
                        (0 until pinSize).forEach {
//                            Icon(
//                                imageVector = if (inputPin.size <= it) Icons.Default.FavoriteBorder else Icons.Outlined.Star,
//                                contentDescription = it.toString(),
//                                modifier = Modifier
//                                    .padding(8.dp)
//                                    .size(30.dp),
//                                tint = Color.Black
//                            )
                            Icon(
                                painter = painterResource(id = if (inputPin.size <= it) R.drawable.circle_border else R.drawable.circle_filled),
                                contentDescription = it.toString(),
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(30.dp),
                                tint = ColorUtils.textColor
                            )
                        }
                    }
                }
                Text(
                    text = error.value,
                    color = androidx.compose.material3.MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )

                Spacer(modifier = Modifier.height(50.dp))
            }

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    (1..3).forEach {
                        PinKeyItem(
                            onClick = { inputPin.add(it) }
                        ) {
                            Text(
                                text = it.toString(),
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(4.dp),
                                color = ColorUtils.subTextColor
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    (4..6).forEach {
                        PinKeyItem(
                            onClick = { inputPin.add(it) }
                        ) {
                            Text(
                                text = it.toString(),
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(4.dp),
                                color = ColorUtils.subTextColor
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    (7..9).forEach {
                        PinKeyItem(
                            onClick = { inputPin.add(it) }
                        ) {
                            Text(
                                text = it.toString(),
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.padding(4.dp),
                                color = ColorUtils.subTextColor
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Success",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable { },
                        tint = ColorUtils.subTextColor,
                    )
                    PinKeyItem(
                        onClick = { inputPin.add(0) },
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                    ) {
                        Text(
                            text = "0",
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(4.dp),
                            color = ColorUtils.subTextColor
                        )
                    }
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Clear",
                        tint = ColorUtils.subTextColor,
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                if (inputPin.isNotEmpty()) {
                                    inputPin.removeLast()
                                }
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun LottieLoadingView(
    context: Context,
    file: String,
    modifier: Modifier = Modifier,
    iterations: Int = 10
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.Asset(file))
    LottieAnimation(
        composition = composition,
        modifier = modifier.defaultMinSize(300.dp),
        iterations = iterations
    )
}

@Composable
fun PinKeyItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier.padding(8.dp),
    shape: Shape = androidx.compose.material.MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = ColorUtils.primaryBackGroundColor,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    elevation: Dp = 4.dp,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        shape = shape,
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = elevation,

//        role = Role.Button,
//        indication = rememberRipple()
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides contentColor.alpha
        ) {
            ProvideTextStyle(
                androidx.compose.material3.MaterialTheme.typography.displayMedium
            ) {
                Box(
                    modifier = Modifier.defaultMinSize(minWidth = 64.dp, minHeight = 64.dp),
                    contentAlignment = Alignment.Center
                ) {
                    content()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit, doItLater: () -> Unit, setPin: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        containerColor = Color.White,
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {

        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Set PIN Reminder",
                color = ColorUtils.primaryBackGroundColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 22F
                ).sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "You haven't set a PIN for added security.",
                color = ColorUtils.secondaryBakgroundColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 16F
                ).sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = Color.Gray, thickness = 2.dp)
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.clickable { setPin() }) {
                Text(
                    text =
                    "Would you like to set a PIN now?",
                    color = ColorUtils.primaryBackGroundColor,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 18F
                    ).sp
                )
                Spacer(modifier = Modifier.width(10.dp))
                androidx.compose.material.Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    tint = ColorUtils.UPI,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        doItLater()
                    },
                text = "Do it Later",
                color = ColorUtils.dismissColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 16F
                ).sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}