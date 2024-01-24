package com.crestinfosystems_jinay.expancetracker.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crestinfosystems_jinay.expancetracker.Graph
import com.crestinfosystems_jinay.expancetracker.data.Expanse
import com.crestinfosystems_jinay.expancetracker.data.ExpanseRepo
import com.crestinfosystems_jinay.expancetracker.model.MainScreenWidget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val expanseRepo: ExpanseRepo = Graph.wishRepository
) : ViewModel() {
    private val _screen = mutableStateOf(ScreenState())
    val screen: State<ScreenState> = _screen
    fun changeScreen(screenState: MainScreenWidget) {
        viewModelScope.launch {
            _screen.value = _screen.value.copy(screenState = screenState)
        }
    }

    data class ScreenState(
        val screenState: MainScreenWidget = MainScreenWidget.Dashboard,
    )

    lateinit var getAllExpanse : Flow<List<Expanse>>
    init {
        viewModelScope.launch {
            getAllExpanse = expanseRepo.getAllExpanse()
        }
    }

    fun addExpanse(expanse: Expanse){
        viewModelScope.launch {
            expanseRepo.addExpanse(expanse)
        }
    }

    fun deleteExpanse(expanse: Expanse){
        viewModelScope.launch {
            expanseRepo.deleteExpanse(expanse)
        }
    }

    fun deleteAll(){
        viewModelScope.launch {
            expanseRepo.deleteAllExpanse()
        }
    }
}