package com.example.composeapril

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(name = "Greeting", showBackground = true, showSystemUi = true)
@Composable
fun Greeting() {
    var checked by rememberSaveable { mutableStateOf(false) }

    /** remember -> есть:
     *
     * rememberSaveable (У remember есть версия,
    которая способна сохранить значение даже при повороте экрана и завершении процесса. Это rememberSaveable.)
     */
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Checkbox(checked = checked, onCheckedChange = { value -> checked = value })
            Text("Some important preference", fontSize = 18.sp)
        }
        if (checked) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(20.dp)
            ) {
                Text("INVISIBLE TEXT VIEW :))")
            }

        }
    }
}