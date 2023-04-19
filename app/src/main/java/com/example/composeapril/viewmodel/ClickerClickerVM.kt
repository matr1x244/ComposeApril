package com.example.composeapril.viewmodel

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ClickerClickerVM() {

    val viewModel: ClickerViewModel = viewModel()
    val counter by viewModel.counter.collectAsState()

    Text(
        text = "Clicks: $counter",
        modifier = Modifier.clickable(onClick = viewModel::onCounterClick)
    )
    println("$counter")
}
