package com.example.composeapril.viewmodel

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClickerClickerVM() {

    val viewModel: ClickerViewModel = viewModel()
    var counter = viewModel.counter

    Text(
        text = "Clicks: ${counter.value}",
        modifier = Modifier.clickable(onClick = viewModel::onCounterClick)
    )
    println("$counter")
}
