package com.example.composeapril

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun List(text: String) {
    println("SomeItem $text")
    val list = remember { mutableListOf("cat 1", "dog 2", "unicorn 3") }
    Text(
        text = text, fontSize = 20.sp,
        modifier = Modifier.padding(16.dp)
    )
}