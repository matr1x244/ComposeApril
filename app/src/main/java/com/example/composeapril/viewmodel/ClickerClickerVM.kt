package com.example.composeapril.viewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapril.R

@Composable
fun ClickerClickerVM() {

    val viewModel: ClickerViewModel = viewModel()
    val clickersState by viewModel.clickerState.collectAsState()

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
    
    Clickers(count = clickersState.count, onCounterClick = viewModel::onCounterClick,
        enabled = clickersState.checkedBox, onEnabledChange = viewModel::onCheckBoxChecked)

    /**
     * ClickerClickerVM берет все необходимые данные из модели и передает в Clickers.
     * Теперь Clickers не привязан к ClickerViewModel и может быть использован на любых других экранах.
     */
}

@Composable
fun Clickers(count: Int, onCounterClick: () -> Unit, enabled: Boolean, onEnabledChange: (Boolean) -> Unit) {
    Box(modifier = Modifier.size(60.dp)
        .border(5.dp, Color.Yellow)
        .background(Color.Cyan)
        .padding(20.dp)
        .border(5.dp, Color.Red)
        .background(Color.Green)) {
        Column {
            Text(
                text = "Clicks: $count",
                modifier = Modifier.clickable(onClick = onCounterClick)
                    .padding(15.dp)
                , fontSize = 20.sp,
            )
            println("$count")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = enabled, onCheckedChange = onEnabledChange, modifier = Modifier.clickable(onClick = onCounterClick))
                if (enabled){
                    Text(text = "checking checkbox VISIBLE")
                } else {
                    Text("checking checkbox INVISIBLE")
                }
            }
        }
    }
}

