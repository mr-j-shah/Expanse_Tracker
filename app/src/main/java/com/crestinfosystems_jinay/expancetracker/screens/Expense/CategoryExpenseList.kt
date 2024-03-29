package com.crestinfosystems_jinay.expancetracker.screens.Expense

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.crestinfosystems_jinay.expancetracker.RouteBackStackKey
import com.crestinfosystems_jinay.expancetracker.ScreenRoute
import com.crestinfosystems_jinay.expancetracker.utils.ColorUtils
import com.crestinfosystems_jinay.expancetracker.viewModel.MainScreenViewModel
import com.crestinfosystems_jinay.expancetracker.widgets.AppBar
import com.crestinfosystems_jinay.expancetracker.widgets.expanseItem
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf

@Composable
fun CategoryExpenseList(
    viewModel: MainScreenViewModel,
    category: String,
    navController: NavController
) {
    var expandedItemId by remember { mutableStateOf<Long?>(null) }
    Scaffold(
        topBar = {
            AppBar(
                title = category,
                onClicked = {
                    navController.popBackStack()
                })
        },
        backgroundColor = ColorUtils.primaryBackGroundColor,
    ) {
        Column(modifier = Modifier.padding(it)) {
            var searchText by remember {
                mutableStateOf("")
            }
            val expanseListData = viewModel.getAllExpanse.combine(flowOf(category)) { list, query ->
                list.filter {
                    it.category.contains(query, ignoreCase = true)
                }
            }.collectAsState(initial = listOf())
            TextField(
                singleLine = true,
                value = searchText,
                onValueChange = { it ->
                    searchText = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent, // Change the color here
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(color = ColorUtils.textColor),
                placeholder = { Text("Search", color = ColorUtils.textColor) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = ColorUtils.textColor
                    )
                },
//                trailingIcon = {
//                    IconButton(onClick = { expanded = true }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.search_from),
//                            contentDescription = null,
//                            tint = ColorUtils.textColor,
//                            modifier = Modifier
//                                .padding(horizontal = 5.dp)
//                                .then(
//                                    ComposeUtils.modifyDimensionsBasedOnScreenSize(
//                                        baseWidth = 30.dp,
//                                        baseHeight = 30.dp
//                                    )
//                                )
//                        )
//                    }
//                    DropdownMenu(
//                        modifier = Modifier.background(color = ColorUtils.primaryBackGroundColor),
//                        expanded = expanded,
//                        onDismissRequest = { expanded = false }
//                    ) {
//                        DropdownMenuItem(onClick = {
//                            searchBy = SearchBy.Title
//                            searchText = ""
//                            expanded = false
//                        }) {
//                            Text("Search By Title", color = ColorUtils.textColor)
//                        }
//                        DropdownMenuItem(onClick = {
//                            searchBy = SearchBy.Description
//                            searchText = ""
//                            expanded = false
//                        }) {
//                            Text("Search By Description", color = ColorUtils.textColor)
//                        }
//                        // Add more items as needed
//                    }
//                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(15.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn() {
                items(expanseListData.value) { expanse ->
                    expanseItem(expanse = expanse, isExpanded = expanse.id == expandedItemId,
                        onToggle = {
                            expandedItemId = if (expanse.id == expandedItemId) null else expanse.id
                        }, onClick = {
                            navController.currentBackStackEntry?.savedStateHandle?.set(
                                RouteBackStackKey.Expense.key,
                                expanse
                            ) // new
                            navController.navigate(ScreenRoute.ExpenseDetailScreen.route)
                        })
                }
            }
        }
    }
}