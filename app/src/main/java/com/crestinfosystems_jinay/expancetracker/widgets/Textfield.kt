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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils

@Composable
fun textFields(
    value: String,
    onChange: (String) -> Unit,
    lable: String,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        singleLine = true,
        value = value,
        onValueChange = {
            onChange(it)
        },
        label = { Text(text = lable, color = ColorUtils.textColor) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
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