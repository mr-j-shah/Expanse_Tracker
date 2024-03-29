package com.crestinfosystems_jinay.expancetracker.screens

import android.widget.Toast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crestinfosystems_jinay.expancetracker.data.Expanse
import com.crestinfosystems_jinay.expancetracker.model.MainScreenWidget
import com.crestinfosystems_jinay.expancetracker.model.PaymentMode
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.textFields
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun AddExpanse(viewModel: MainScreenViewModel) {
    val calendar = Calendar.getInstance()

    var selectedDate by remember {
        mutableLongStateOf(calendar.timeInMillis) // or use mutableStateOf(calendar.timeInMillis)
    }

    val state = rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis)
    var showDatePicker by remember {
        mutableStateOf(false)
    }
    var title by remember {
        mutableStateOf("")
    }
    var desc by remember {
        mutableStateOf("")
    }
    var amount by remember {
        mutableStateOf("")
    }
    var amountval by remember {
        mutableStateOf(0.0)
    }
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.ROOT)
    val context = LocalContext.current

    //Category of Expense
    val categoryList =
        arrayOf("Home Product", "EMIs/Bills", "Gifts", "Travelling", "Festival", "Fashion")
    var expanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf(categoryList[0]) }

    //Payment Mode Options
    val paymentModeList = arrayOf(
        PaymentMode.Cash.name,
        PaymentMode.CreditCard.name,
        PaymentMode.DebitCard.name,
        PaymentMode.UPI.name,
    )
    var expandedPaymentMode by remember { mutableStateOf(false) }
    var paymentMode by remember { mutableStateOf(paymentModeList[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState(),
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showDatePicker) {
            DatePickerDialog(onDismissRequest = {
                showDatePicker = false
            }, confirmButton = {
                TextButton(onClick = {
                    showDatePicker = false
                    selectedDate = state.selectedDateMillis!!
                }) {
                    Text(text = "Confirm")
                }
            }, dismissButton = {
                TextButton(onClick = {
                    showDatePicker = false
                }) {
                    Text(text = "Cancel")
                }
            }) {
                DatePicker(
                    state = state
                )
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        textFields(value = title, lable = "Title", onChange = {
            title = it
        }, keyboardType = KeyboardType.Text)
        Spacer(modifier = Modifier.height(10.dp))
        textFields(value = desc, lable = "Description", onChange = {
            desc = it
        }, keyboardType = KeyboardType.Text, minLine = 5)
        Spacer(modifier = Modifier.height(10.dp))
        textFields(value = amount.toString(), lable = "Amount", onChange = {
            amount = it
            amountval = amount.toDoubleOrNull() ?: 0.0
        }, keyboardType = KeyboardType.Number)
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            enabled = false,
            singleLine = true,
            value = formatter.format(Date(selectedDate)),
            onValueChange = {

            },
            label = { Text(text = "Date", color = ColorUtils.textColor) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            trailingIcon = {
                IconButton(onClick = { showDatePicker = true }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "",
                        tint = ColorUtils.textColor
                    )
                }
            },
            textStyle = TextStyle(fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(baseSize = 14F).sp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledBorderColor = ColorUtils.secondaryBakgroundColor,
                disabledTextColor = ColorUtils.textColor,
                textColor = ColorUtils.textColor,
                focusedBorderColor = ColorUtils.secondaryBakgroundColor,
                focusedLabelColor = ColorUtils.secondaryBakgroundColor,
                unfocusedBorderColor = ColorUtils.secondaryBakgroundColor,
                unfocusedLabelColor = ColorUtils.secondaryBakgroundColor,
                cursorColor = ColorUtils.secondaryBakgroundColor
            ),
            shape = RoundedCornerShape(15.dp),
        )
        Spacer(modifier = Modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            OutlinedTextField(
                readOnly = true,
                singleLine = true,
                value = category,
                onValueChange = {},
                label = { Text(text = "Category", color = ColorUtils.textColor) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 14F
                    ).sp,
                ),
                trailingIcon = {
                    IconButton(onClick = { expanded = true },
                        modifier = Modifier.clearAndSetSemantics { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "",
                            modifier = Modifier.rotate(
                                if (expanded) 180f
                                else 360f
                            ),
                            tint = ColorUtils.textColor
                        )
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = ColorUtils.secondaryBakgroundColor,
                    disabledTextColor = ColorUtils.textColor,
                    textColor = ColorUtils.textColor,
                    focusedBorderColor = ColorUtils.secondaryBakgroundColor,
                    focusedLabelColor = ColorUtils.secondaryBakgroundColor,
                    unfocusedBorderColor = ColorUtils.secondaryBakgroundColor,
                    unfocusedLabelColor = ColorUtils.secondaryBakgroundColor,
                    cursorColor = ColorUtils.secondaryBakgroundColor
                ),
                shape = RoundedCornerShape(15.dp),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                categoryList.forEach { item ->
                    DropdownMenuItem(text = { Text(text = item) }, onClick = {
                        category = item
                        expanded = false
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = expandedPaymentMode,
            onExpandedChange = {
                expandedPaymentMode = !expandedPaymentMode
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            OutlinedTextField(
                readOnly = true,
                singleLine = true,
                value = paymentMode,
                onValueChange = {},
                label = { Text(text = "Payment Mode", color = ColorUtils.textColor) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                        baseSize = 14F
                    ).sp,
                ),
                trailingIcon = {
                    IconButton(onClick = { expandedPaymentMode = true },
                        modifier = Modifier.clearAndSetSemantics { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "",
                            modifier = Modifier.rotate(
                                if (expanded) 180f
                                else 360f
                            ),
                            tint = ColorUtils.textColor
                        )
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    disabledBorderColor = ColorUtils.secondaryBakgroundColor,
                    disabledTextColor = ColorUtils.textColor,
                    textColor = ColorUtils.textColor,
                    focusedBorderColor = ColorUtils.secondaryBakgroundColor,
                    focusedLabelColor = ColorUtils.secondaryBakgroundColor,
                    unfocusedBorderColor = ColorUtils.secondaryBakgroundColor,
                    unfocusedLabelColor = ColorUtils.secondaryBakgroundColor,
                    cursorColor = ColorUtils.secondaryBakgroundColor
                ),
                shape = RoundedCornerShape(15.dp),
            )
            ExposedDropdownMenu(
                expanded = expandedPaymentMode,
                onDismissRequest = { expandedPaymentMode = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                paymentModeList.forEach { item ->
                    DropdownMenuItem(text = { Text(text = item) }, onClick = {
                        paymentMode = item
                        expandedPaymentMode = false
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                viewModel.addExpanse(
                    Expanse(
                        title = title,
                        des = desc,
                        amount = amount.toFloat(),
                        date = formatter.format(Date(selectedDate)),
                        category = category,
                        mode = paymentMode
                    )
                )
                Toast.makeText(context, "Expense Added Successfully", Toast.LENGTH_SHORT).show()
                viewModel.changeScreen(MainScreenWidget.Stetestic)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
                .then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 40.dp)),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = ColorUtils.secondaryBakgroundColor)
        ) {
            Text(
                "Add", color = Color.White, style = TextStyle(fontSize = 18.sp)
            )
        }
    }

}