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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar

@Composable
fun FAQs(navController: NavController) {
    Scaffold(
        topBar = {
            AppBar(title = "FAQs", onClicked = {
                navController.popBackStack()
            })
        }, backgroundColor = ColorUtils.primaryBackGroundColor
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            QATile(
                question = "How do I edit or delete an expense?",
                ans = "Navigate to the specific expense in the \"Dashboard\" or \"Categories\" section and use the respective options."
            )
            QATile(
                question = "Can I change the default categories?",
                ans = "No, You can't modify the predefined categories."
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun QATile(question: String, ans: String) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp),
        elevation = 10.dp,
        backgroundColor = ColorUtils.secondaryBakgroundColor
    ) {
        Column(Modifier.padding(12.dp)) {
            Row() {
                Text(
                    text = "Q.",
                    color = ColorUtils.subTextColor,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 14F
                    ).sp,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = question,
                    color = ColorUtils.subTextColor,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 14F
                    ).sp,
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                Text(
                    text = "A.",
                    color = ColorUtils.subTextColor,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 14F
                    ).sp,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = ans,
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
}