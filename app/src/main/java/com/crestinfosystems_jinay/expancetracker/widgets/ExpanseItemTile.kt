package com.crestinfosystems_jinay.expancetracker.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.data.Expanse
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils

@Composable
fun expanseItem(expanse: Expanse, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 8.dp, end = 8.dp)
            .clickable {
                onClick()
            },
        elevation = 10.dp,
        backgroundColor = ColorUtils.secondaryBakgroundColor
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.tent),
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
                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    modifier = Modifier.then(
                        ComposeUtils.modifyDimensionsBasedOnScreenSize(
                            baseWidth = 200.dp,
                            baseHeight = 50.dp
                        )
                    ), verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = expanse.title,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Justify,
                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 20F).sp,
                        color = ColorUtils.textColor
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = expanse.date.toString(),
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Justify,
                        color = ColorUtils.subTextColor,
                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 14F).sp,
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        imageVector = Icons.Default.Edit,
//                        contentDescription = "",
//                        tint = ColorUtils.subTextColor
//                    )
//                }

            }

//            Spacer(modifier = Modifier.height(5.dp))
//            Text(
//                text = expanse.des,
//                fontWeight = FontWeight.SemiBold,
//                fontFamily = FontFamily.SansSerif,
//                textAlign = TextAlign.Justify,
//                fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 14F).sp,
//                color = ColorUtils.subTextColor
//            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.rupee_symbol),
                    contentDescription = "",
//                    tint = Color(0xFFE75450),
                    tint = ColorUtils.primaryBackGroundColor,
                    modifier = Modifier.then(
                        ComposeUtils.modifyDimensionsBasedOnScreenSize(
                            baseHeight = 20.dp,
                            baseWidth = 20.dp
                        )
                    )
                )
                Spacer(
                    modifier = Modifier.then(
                        ComposeUtils.modifyDimensionsBasedOnScreenSize(
                            baseHeight = 0.dp,
                            baseWidth = 10.dp
                        )
                    )
                )
                Text(

                    text = expanse.amount.toString(),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Justify,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 16F).sp,
                    color = ColorUtils.textColor
                )
            }
        }
    }
}