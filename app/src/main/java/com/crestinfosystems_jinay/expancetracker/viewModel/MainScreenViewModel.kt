package com.crestinfosystems_jinay.expancetracker.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crestinfosystems_jinay.expancetracker.Graph
import com.crestinfosystems_jinay.expancetracker.data.Expanse
import com.crestinfosystems_jinay.expancetracker.data.ExpanseRepo
import com.crestinfosystems_jinay.expancetracker.data.Wish
import com.crestinfosystems_jinay.expancetracker.model.MainScreenWidget
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val expanseRepo: ExpanseRepo = Graph.wishRepository
) : ViewModel() {
    private val _screen = mutableStateOf(ScreenState())
    val screen: State<ScreenState> = _screen
    var wishTitle by mutableStateOf("")
    var wishDesc by mutableStateOf("")
    var wishDone by mutableStateOf(false)

    fun onWishTitleChange(newString :String){
        wishTitle = newString
    }
    fun onWishDescChange(newString:String){
        wishDesc=newString
    }
    fun changeScreen(screenState: MainScreenWidget) {
        viewModelScope.launch {
            _screen.value = _screen.value.copy(screenState = screenState)
        }
    }
    fun updateWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            expanseRepo.updateWish(wish)
        }
    }
    data class ScreenState(
        val screenState: MainScreenWidget = MainScreenWidget.Dashboard,
    )
    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            expanseRepo.addWish(wish)
        }
    }
    lateinit var getAllExpanse : Flow<List<Expanse>>
    lateinit var getAllWishes : Flow<List<Wish>>
    lateinit var getTotalExpanse : Flow<Float>
    init {
        viewModelScope.launch {
            getAllExpanse = expanseRepo.getAllExpanse()
            getAllWishes = expanseRepo.getAllWishes()
            getTotalExpanse = expanseRepo.getTotalExpanse()
        }
    }
    fun deleteWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            expanseRepo.deleteWish(wish)
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
    fun getAwishById(id:Long):Flow<Wish>{
        return expanseRepo.getWish(id)
    }

}