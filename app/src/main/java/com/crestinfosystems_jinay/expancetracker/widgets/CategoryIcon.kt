package com.crestinfosystems_jinay.expancetracker.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CategoryIcon(id:Int) {
    Image(
        painter = painterResource(id),
        contentDescription = "avatar",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(50.dp)
//            .clip(CircleShape)                       // clip to the circle shape
//            .border(
//                2.dp,
//                ColorUtils.secondaryBakgroundColor,
//                CircleShape
//            )   // add a border (optional)
    )
}