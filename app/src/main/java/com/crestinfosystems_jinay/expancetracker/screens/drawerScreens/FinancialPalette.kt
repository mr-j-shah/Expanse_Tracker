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
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar

@Composable
fun FinancialPalette(navController: NavController) {
    Scaffold(
        topBar = {
            AppBar(title = "Financial Palette", onClicked = {
                navController.popBackStack()
            })
        }, backgroundColor = ColorUtils.primaryBackGroundColor
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            FinancialColorPaletteTile(
                color = Color(0xFF4CAF50),
                title = "1. UPI (Unified Payments Interface):",
                colorname = "Green",
                desciption = listOf("Green is often associated with positive actions, success, and safety." ,
                        "In many cultures, green signifies \"go\" or approval, making it suitable for a successful payment." ,
                        "Green is commonly used in financial and banking applications to convey a sense of trust and reliability.")
            )
            FinancialColorPaletteTile(
                color = Color(0xFF3498DB),
                title = "2. Debit Card:",
                colorname = "Blue",
                desciption = listOf("Blue is associated with stability, trust, and security." ,
                        "It's a widely used color in the banking and financial sector, creating a sense of reliability.",
                        "Blue is often seen as a calming and trustworthy color, which aligns well with financial transactions.")
            )
            FinancialColorPaletteTile(
                color = Color(0xFFFFA500),
                title = "3. Credit Card:",
                colorname = "Orange",
                desciption = listOf("Orange is associated with enthusiasm, energy, and creativity." ,
                        "Credit cards often represent spending and rewards, and orange can evoke a sense of excitement." ,
                        "It provides a distinct visual identity compared to debit cards while maintaining a positive and vibrant feel.")
            )
            FinancialColorPaletteTile(
                color = Color(0xFF8D6E63),
                title = "4. Cash:",
                colorname = "Bison Hide",
                desciption = listOf("Warm and Earthy: The warm and earthy tones of Bison Hide evoke a sense of reliability and groundedness, which can be associated with physical cash. It provides a traditional and tangible feel, reminiscent of natural elements.",
                        "Contrast on Dark Background: Against a dark background, #8D6E63 provides good contrast and readability. The slightly muted and subdued nature of this brown shade complements the overall dark theme while maintaining visibility." ,
                        "Cultural Association: Brown is often associated with currency, leather, and other physical elements. This can resonate well with the concept of cash, which is a tangible form of currency.")
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun FinancialColorPaletteTile(color: Color, title: String, desciption: List<String>, colorname: String) {

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
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = colorname,
                    color = ColorUtils.subTextColor,
                    textAlign = TextAlign.Justify,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 17F
                    ).sp,
                )
                Icon(
                    painter = painterResource(id = R.drawable.dot),
                    contentDescription = "",
//            tint = Color(0xFF4CAF50)color,
                    tint = color,
                    modifier = Modifier.then(
                        ComposeUtils.modifyDimensionsBasedOnScreenSize(
                            baseWidth = 32.dp,
                            baseHeight = 32.dp
                        )
                    ),
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            for (text in desciption){
                LineWithBulletinDot(text = text)
            }

        }
    }

}

@Composable
fun LineWithBulletinDot(text:String) {
    Row(modifier = Modifier.padding(start = 6.dp)) {
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
            text = text,
            color = ColorUtils.subTextColor,
            textAlign = TextAlign.Justify,
            fontFamily = FontFamily.SansSerif,
            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                baseSize = 14F
            ).sp,
        )
    }
}

