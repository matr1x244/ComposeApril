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

    /**
     * Функция collectAsState подписывается на StateFlow и предоставляет State.
     * Каждый раз, когда значение в StateFlow меняется, обновляется и значение State.
     *
    Получается такая схема подписки:
    Composable -> State -> StateFlow
     *
    Composable читает значение из State, и тем самым подписывается на него,
    чтобы перезапуститься при изменении значения. А State подписывается на StateFlow.
    В итоге изменение значения в StateFlow будет приводить к перезапуску Composable функции.
     */
    
    Clickers(count = counter, onCounterClick = viewModel::onCounterClick)

    /**
     * ClickerClickerVM берет все необходимые данные из модели и передает в Clickers.
     * Теперь Clickers не привязан к ClickerViewModel и может быть использован на любых других экранах.
     */
}

@Composable
fun Clickers(count: Int, onCounterClick: () -> Unit) {
    Text(
        text = "Clicks: $count",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
    println("$count")
}

