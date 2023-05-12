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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapril.viewmodel.UsersSharedViewModel

@Composable
fun NavigationUsers(
    onUserClick: () -> Unit,
    usersSharedViewModel: UsersSharedViewModel = viewModel()
) {
    Column {
        Text(text = "Users screen", modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 20.dp)
            .align(alignment = CenterHorizontally))

        Text(
            text = "User",
            modifier = Modifier.clickable(onClick = onUserClick))

    }
}