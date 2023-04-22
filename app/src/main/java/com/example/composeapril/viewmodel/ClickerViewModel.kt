package com.example.composeapril.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ClickerViewModel: ViewModel() {

    private val _clickerState = MutableStateFlow(ClickerDataState())
    val clickerState: StateFlow<ClickerDataState> = _clickerState

    fun onCounterClick() {
        viewModelScope.launch(Dispatchers.IO) {
            _clickerState.update {
                it.copy(count = it.count + 1)
            }
        }
    }

    fun onCheckBoxChecked(checkValue: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            _clickerState.update {
                it.copy(checkedBox = checkValue, count = it.count + 1)
            }
        }
    }
}