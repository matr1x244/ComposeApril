package com.example.composeapril

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapril.ui.theme.ComposeAprilTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAprilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting()

                    val list = remember { mutableStateListOf("cat 1", "dog 2", "unicorn 3") }
                    val scroll = rememberScrollState()
                    Column(Modifier.padding(0.dp, 30.dp)
                        .verticalScroll(scroll)) {
                        TextButton(onClick = {
                            list.add("Dragon ${list.size + 1}")
                        }) {
                            Text(text = "ADD")
                        }
                        TextButton(onClick = {
                            list.removeFirst()
                        }) {
                            Text(text = "REMOVE")
                        }
                        TextButton(onClick = {
                            list.shuffle()
                        }) {
                            Text(text = "Shuffle")
                        }
                        list.forEach { valueText ->
                                List(valueText)
                        }
                    }
                }
            }
        }
    }
}
