package com.example.composeapril.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavigationUsers(
    onUser100Click: () -> Unit,
    onUser200Click: () -> Unit,
) {
    Column {
        Text(text = "Users screen", modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .align(alignment = CenterHorizontally))

        Text(
            text = "User 1",
            modifier = Modifier.clickable(onClick = onUser100Click))

        Text(
            text = "User 2",
            modifier = Modifier.clickable(onClick = onUser200Click)
        )
    }
}