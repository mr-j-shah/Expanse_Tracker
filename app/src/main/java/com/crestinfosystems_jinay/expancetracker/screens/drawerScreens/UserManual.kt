package com.crestinfosystems_jinay.expancetracker.screens.drawerScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar

@Composable
fun UserManual(navController: NavController) {
    Scaffold(
        topBar = {
            AppBar(title = "User Manual", onClicked = {
                navController.popBackStack()
            })
        }, backgroundColor = ColorUtils.primaryBackGroundColor
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            UserManualTile(
                title = "Introduction",
                desciption = "Welcome to the Expense Tracker application! This app helps you manage and track your expenses efficiently. It allows you to categorize expenses, record payment modes, and even keep a wishlist. This user manual provides step-by-step guidance on using the app's key features."
            )
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                elevation = 10.dp,
                backgroundColor = ColorUtils.secondaryBakgroundColor
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "Adding an Expense",
                        color = ColorUtils.textColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                            baseSize = 20F
                        ).sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row() {
                        Text(
                            text = "1.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Open the app and navigate to the \"Add Expense\" section.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row() {
                        Text(
                            text = "2.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Fill in the following details:",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row(modifier = Modifier.padding(start = 12.dp)) {
                        Text(
                            text ="\u2022",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Title: Briefly describe the expense.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row(modifier = Modifier.padding(start = 12.dp)) {
                        Text(
                            text ="\u2022",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Description: Provide additional details about the expense.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row(modifier = Modifier.padding(start = 12.dp)) {
                        Text(
                            text ="\u2022",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Date: Select the date of the expense.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row(modifier = Modifier.padding(start = 12.dp)) {
                        Text(
                            text ="\u2022",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Amount: Enter the expense amount.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row(modifier = Modifier.padding(start = 12.dp)) {
                        Text(
                            text ="\u2022",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Type: Choose from categories like Travelling, Fashion, Gift, EMI/Bills, Home Product, Festival.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row(modifier = Modifier.padding(start = 12.dp)) {
                        Text(
                            text ="\u2022",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Mode of Payment: Select Cash, Debit Card, Credit Card, or UPI.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }
                    Row() {
                        Text(
                            text = "3.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Click \"Save\" to record the expense.",
                            color = ColorUtils.subTextColor,
                            textAlign = TextAlign.Justify,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                baseSize = 14F
                            ).sp,
                        )
                    }

                }
            }
            UserManualTile(
                title = "Dashboard",
                desciption = "The dashboard provides an overview of your expenses.\n" +
                        "\n" +
                        "\u2022" + "\t" + "Total Expenses: Displays the sum of all recorded expenses.\n" +
                        "\u2022" + "\t" + "Category-wise Expenses: Visual representation of expenses based on categories."
            )
            UserManualTile(
                title = "Wish List",
                desciption = "In the app's drawer, find the \"Wish List\" option. Use this feature to add items you wish to purchase or achieve."
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}

@Composable
fun UserManualTile(title: String, desciption: String) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp),
        elevation = 10.dp,
        backgroundColor = ColorUtils.secondaryBakgroundColor
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = title,
                color = ColorUtils.textColor,
                fontWeight = FontWeight.Bold,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 20F
                ).sp
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = desciption,
                color = ColorUtils.subTextColor,
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily.SansSerif,
                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                    baseSize = 14F
                ).sp,
            )
        }
    }

}