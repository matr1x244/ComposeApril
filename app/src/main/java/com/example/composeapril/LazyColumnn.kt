package com.example.composeapril

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private val countryList =
    mutableStateListOf("India", "Pakistan", "China", "United States")

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.Gray)
    .padding(35.dp)


private val textStyle = TextStyle(fontSize = 20.sp, color = Color.White)

@Composable
fun LazyColumnn() {
    LazyColumn(modifier = listModifier) {
        items(countryList) { country ->
            Text(text = country, style = textStyle)
        }
    }
    AddNew()
}

@Composable
fun AddNew() {
    val styleModifier = Modifier.fillMaxWidth().absolutePadding(10.dp,0.dp,10.dp,5.dp)

    Column(styleModifier, verticalArrangement = Arrangement.SpaceBetween
    ) {
        TextButton(onClick = {
            countryList.add("NEW ${countryList.size + 1}")
        }) {
            Text(text = "ADD", fontSize = 20.sp)
        }
    }
}