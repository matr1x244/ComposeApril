package com.example.composeapril.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ClickerViewModel: ViewModel() {

    private val _counter = mutableStateOf(0)
    val counter: State<Int> = _counter

    fun onCounterClick() {
        _counter.value++
    }

}