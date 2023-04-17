package com.example.composeapril

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp

@Composable
fun Greeting () {
    val checked = remember { mutableStateOf(false) }
    val checkedValue = checked.value

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checkedValue, onCheckedChange = {value -> checked.value = value})
            Text("Some important preference",  fontSize = 18.sp)
        }
        if(checkedValue) {
            Text("INVISIBLE TEXT VIEW :))")
        }
    }
}