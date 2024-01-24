package com.crestinfosystems_jinay.expancetracker.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils

@Composable
fun CategoryTile(imageId: Int, title: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.then(
            ComposeUtils.modifyDimensionsBasedOnScreenSize(
                baseWidth = 90.dp,
                baseHeight = 90.dp
            )
        )
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(
                    2.dp,
                    ColorUtils.secondaryBakgroundColor,
                    CircleShape
                )   // add a border (optional)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            color = ColorUtils.textColor,
            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                baseSize = 13F
            ).sp
        )
    }

}