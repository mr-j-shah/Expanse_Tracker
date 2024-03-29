package com.crestinfosystems_jinay.expancetracker.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils

@Composable
fun textFields(
    enable:Boolean = true,
    value: String,
    onChange: (String) -> Unit,
    lable: String,
    keyboardType: KeyboardType,
    minLine:Int = 1,
    modifier:Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 15.dp),
) {
    OutlinedTextField(
        enabled = enable,
        minLines = minLine,
        value = value,
        onValueChange = {
            onChange(it)
        },
        label = { Text(text = lable, color = ColorUtils.textColor) },
        textStyle = TextStyle( fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 14F).sp,),
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType,imeAction = ImeAction.Done),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = ColorUtils.textColor,
            focusedBorderColor = ColorUtils.secondaryBakgroundColor,
            focusedLabelColor = ColorUtils.secondaryBakgroundColor,
            unfocusedBorderColor = ColorUtils.secondaryBakgroundColor,
            unfocusedLabelColor = ColorUtils.secondaryBakgroundColor,
            cursorColor = ColorUtils.secondaryBakgroundColor
        ),
        shape = RoundedCornerShape(15.dp),
    )
}