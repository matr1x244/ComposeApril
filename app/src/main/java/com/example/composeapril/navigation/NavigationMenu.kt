package com.example.composeapril.navigation

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationHomeScreen(onSaleClick: () -> Unit = {}) {
    Text(text = "Home screen OPEN",
        modifier = Modifier.clickable(onClick = onSaleClick)
    )
}

@Composable
fun NavigationSaleScreen(){
    Text(text = "Sale Screen OPEN")
}

@Composable
fun NavigationWalletScreen(){
    Text(text = "Wallet Screen OPEN")
}

/**
 * Вложенные экраны
 */

@Composable
fun NavigationWalletScreenDetail(){
    Text(text = "NavigationWalletScreenDetail OPEN Detail")
}