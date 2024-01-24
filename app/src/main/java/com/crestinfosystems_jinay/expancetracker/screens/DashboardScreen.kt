package com.crestinfosystems_jinay.expancetracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.CategoryTile

@Composable
fun DashboardScreen(viewModel: MainScreenViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                .clickable {

                },
            elevation = 10.dp,
            backgroundColor = ColorUtils.secondaryBakgroundColor
        ) {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Icon", color = ColorUtils.textColor)
                Divider(
                    color = Color.Blue, modifier = Modifier
                        .width(2.dp)
                )
                Text(text = "Value", color = ColorUtils.textColor)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                .clickable {

                },
            elevation = 10.dp,
            backgroundColor = ColorUtils.secondaryBakgroundColor
        ) {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Icon", color = ColorUtils.textColor)
                Divider(
                    color = Color.Blue, modifier = Modifier
                        .width(2.dp)
                )
                Text(text = "Value", color = ColorUtils.textColor)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryTile(imageId = R.drawable.home_product, title = "Home Products")
            CategoryTile(imageId = R.drawable.giftbox, title = "Gifts")
            CategoryTile(imageId = R.drawable.pay, title = "EMIs/Bills")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryTile(imageId = R.drawable.suitcase, title = "Travel")
            CategoryTile(imageId = R.drawable.fashion, title = "Fashion")
            CategoryTile(imageId = R.drawable.tent, title = "Festival")
        }
    }
}