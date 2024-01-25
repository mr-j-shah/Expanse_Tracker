package com.crestinfosystems_jinay.expancetracker.screens

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberDismissState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.R
import com.crestinfosystems_jinay.expancetracker.ScreenRoute
import com.crestinfosystems_jinay.expancetracker.data.Expanse
import com.crestinfosystems_jinay.expancetracker.model.MainScreenWidget
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.utils.ComposeUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar
import com.crestinfosystems_jinay.expancetracker.widgets.CategoryIcon
import com.crestinfosystems_jinay.expancetracker.widgets.wishItem
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import java.util.Date

@Composable
fun ExpanseDetailScreen(
    expanse: Expanse,
    viewModel: MainScreenViewModel,
    navController: NavController
) {
    val snackMessage = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    var changeTitle by remember {
        mutableStateOf(expanse.title)
    }
    var changeDes by remember {
        mutableStateOf(expanse.des)
    }
    var enableToChange by remember {
        mutableStateOf(false)
    }
    val scffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scffoldState,
        topBar = {
            AppBar(
                title = "Expense",
                onClicked = {
                    navController.popBackStack()
                })
        },
        backgroundColor = ColorUtils.primaryBackGroundColor,
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 8.dp, end = 8.dp),
                    elevation = 10.dp,
                    backgroundColor = ColorUtils.secondaryBakgroundColor
                ) {
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
                                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                            baseSize = 20F
                                        ).sp,
                                        color = ColorUtils.textColor
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = expanse.date.toString(),
                                        fontWeight = FontWeight.SemiBold,
                                        textAlign = TextAlign.Justify,
                                        color = ColorUtils.subTextColor,
                                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                                            baseSize = 14F
                                        ).sp,
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
                        Spacer(modifier = Modifier.width(10.dp))
                        IconButton(onClick = {
                            enableToChange = !enableToChange
                        }) {
                            Icon(
                                imageVector = if (enableToChange) Icons.Default.Close else Icons.Default.Edit,
                                contentDescription = "",
                                tint = ColorUtils.primaryBackGroundColor,
                                modifier = Modifier.then(
                                    ComposeUtils.modifyDimensionsBasedOnScreenSize(
                                        baseHeight = 25.dp,
                                        baseWidth = 25.dp
                                    )
                                )
                            )
                        }

                    }

                }
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    enabled = enableToChange,
                    singleLine = true,
                    value = expanse.title,
                    onValueChange = {

                    },
                    label = { Text(text = "Title", color = ColorUtils.textColor) },
                    textStyle = TextStyle(
                        fontSize = ComposeUtils.modifyTextSizeBasedOnScreenSize(
                            baseSize = 14F
                        ).sp,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 8.dp, end = 8.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
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
                Spacer(modifier = Modifier.height(10.dp))
                com.crestinfosystems_jinay.expancetracker.widgets.textFields(
                    value = changeDes,
                    lable = "Description",
                    onChange = { value ->
                        changeDes = value
                    },
                    keyboardType = KeyboardType.Text,
                    minLine = 5,
                    enable = enableToChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 8.dp, end = 8.dp)
                )
                if (enableToChange) {
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp, start = 8.dp, end = 8.dp)
                            .then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 40.dp)),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = ColorUtils.secondaryBakgroundColor)
                    ) {
                        Text(
                            "Update Expanse",
                            color = Color.White,
                            style = TextStyle(fontSize = 18.sp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    onClick = {
                        viewModel.deleteExpanse(
                            expanse
                        )
                        snackMessage.value = "Expense has been Deleted"
                        scope.launch {
                            scffoldState.snackbarHostState.showSnackbar(snackMessage.value)
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp, start = 8.dp, end = 8.dp)
                        .then(ComposeUtils.modifyDimensionsBasedOnScreenSize(baseHeight = 40.dp)),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = ColorUtils.dismissColor)
                ) {
                    Text(
                        "Delete Expanse",
                        color = Color.White,
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            }
        }
    }
}