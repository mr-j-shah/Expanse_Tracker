package com.crestinfosystems_jinay.expancetracker.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.data.Expanse
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils

@Composable
fun expanseItem(expanse: Expanse, onClick: () -> Unit, isExpanded: Boolean, onToggle: () -> Unit) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 8.dp, end = 8.dp)
            .clickable {
                onClick()
            }.animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
        elevation = 10.dp,
        backgroundColor = ColorUtils.secondaryBakgroundColor
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .then(
                            ComposeUtils.modifyDimensionsBasedOnScreenSize(
                                baseHeight = 75.dp,
                                baseWidth = 260.dp
                            )
                        ),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        when (expanse.category) {
                            "Home Product" -> CategoryIcon(id = R.drawable.home_product)
                            "EMIs/Bills" -> CategoryIcon(id = R.drawable.pay)
                            "Gifts" -> CategoryIcon(id = R.drawable.giftbox)
                            "Travelling" -> CategoryIcon(id = R.drawable.suitcase)
                            "Festival" -> CategoryIcon(id = R.drawable.tent)
                            "Fashion" -> CategoryIcon(id = R.drawable.fashion)
                        }
                        Spacer(modifier = Modifier.width(25.dp))
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


                    }


                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.rupee_symbol),
                            contentDescription = "",
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
                Spacer(modifier = Modifier.width(15.dp))
                IconButton(onClick = { onToggle() }) {
                    Icon(
                        imageVector = if (!isExpanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                        contentDescription = "",
                        tint = ColorUtils.primaryBackGroundColor,
                        modifier = Modifier.then(
                            ComposeUtils.modifyDimensionsBasedOnScreenSize(
                                baseHeight = 30.dp,
                                baseWidth = 30.dp
                            )
                        )
                    )
                }

            }
            if (isExpanded) {
                Text(
                    expanse.des, modifier = Modifier
                        .padding(16.dp),
                    color = ColorUtils.textColor,

                    textAlign = TextAlign.Justify,
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 14F).sp,
                )

            }
        }
    }
}