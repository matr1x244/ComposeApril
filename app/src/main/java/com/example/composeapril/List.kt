package com.example.composeapril

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun List(text: String) {
    val context = LocalContext.current

    println("SomeItem $text")
    val list = remember { mutableListOf("cat 1", "dog 2", "unicorn 3") }
    Text(
        text = text, fontSize = 20.sp,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Black)
            .padding(2.dp)
            .clickable {
                Toast
                    .makeText(context, "Text: clicker $text", Toast.LENGTH_SHORT)
                    .show()
            })
}