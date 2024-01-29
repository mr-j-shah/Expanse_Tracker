package com.crestinfosystems_jinay.expancetracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.ScreenRoute
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.CategoryTile

@Composable
fun DashboardScreen(viewModel: MainScreenViewModel,navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                .then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 80.dp)),
            elevation = 10.dp,
            backgroundColor = ColorUtils.secondaryBakgroundColor
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(R.drawable.total_expense_report),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(50.dp)

                )
                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(ColorUtils.subTextColor)
                )
                Text(
                    text = (viewModel.getTotalExpanse.collectAsState(initial = 0F).value?:0f).toString(),
                    color = ColorUtils.textColor,
                    modifier = Modifier.then(
                        ComposeUtils
                            .modifyDimensionsBasedOnScreenSize(
                                baseWidth = 180.dp,
                                baseHeight = 20.dp
                            )
                            .align(Alignment.CenterVertically)
                    ),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Justify,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 20F).sp,
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryTile(imageId = R.drawable.home_product, title = "Home Products", onTap = {
                navController.navigate(ScreenRoute.CategoryViseExpense.route + "/Home")
            })
            CategoryTile(imageId = R.drawable.giftbox, title = "Gifts", onTap = {
                navController.navigate(ScreenRoute.CategoryViseExpense.route + "/Gifts")
            })
            CategoryTile(imageId = R.drawable.pay, title = "EMIs/Bills", onTap = {
                navController.navigate(ScreenRoute.CategoryViseExpense.route + "/EMIs")
            })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryTile(imageId = R.drawable.suitcase, title = "Travel", onTap = {
                navController.navigate(ScreenRoute.CategoryViseExpense.route + "/Travel")
            })
            CategoryTile(imageId = R.drawable.fashion, title = "Fashion", onTap = {
                navController.navigate(ScreenRoute.CategoryViseExpense.route + "/Fashion")
            })
            CategoryTile(imageId = R.drawable.tent, title = "Festival", onTap = {

                navController.navigate(ScreenRoute.CategoryViseExpense.route + "/Festival")
            })
        }
    }
}