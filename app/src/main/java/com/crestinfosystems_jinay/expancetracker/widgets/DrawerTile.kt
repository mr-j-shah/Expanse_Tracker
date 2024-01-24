package com.crestinfosystems_jinay.expancetracker.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils

@Composable
fun DrawerTile(onClick: () -> Unit, id: Int, title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
            .padding(vertical = 5.dp)) {
        Image(
            painter = painterResource(id = id),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = ColorUtils.subTextColor)
                .padding(2.dp)
//                .border(width = 0.dp, color = ColorUtils.primaryBackGroundColor)
                ,
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = title,
            color = ColorUtils.textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                baseSize = 16F
            ).sp
        )
    }
}