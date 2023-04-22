package com.example.composeapril

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun ClickerText() {
    val message = remember { mutableStateOf("jetpack Compose OK") }

    Text(message.value, modifier = Modifier.clickable(onClick = { message.value = "Hello World!" }))
}