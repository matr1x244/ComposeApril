package com.example.composeapril

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapril.navigation.NavigationHomeScreen
import com.example.composeapril.navigation.NavigationSaleScreen
import com.example.composeapril.navigation.NavigationWalletScreen
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
                    /**
                     * Navigation default compose
                     */
                    NavigationScreen()
                }
            }
        }
    }

    @Composable
    private fun NavigationScreen() {
        Column(modifier = Modifier.fillMaxSize()) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.weight(1f)
            ) {
                composable("home") { NavigationHomeScreen() }
                composable("sale") { NavigationSaleScreen() }
                composable("wallet") { NavigationWalletScreen() }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(60.dp)
                    .padding(5.dp, 0.dp)
                    .background(
                        Color.Red,
                        shape = RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    ),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "home", modifier = Modifier
                        .clickable { navController.navigate("home") },
                    color = Color.White
                )
                Text(
                    text = "sale",
                    modifier = Modifier.clickable { navController.navigate("sale") },
                    color = Color.White
                )
                Text(
                    text = "wallet",
                    modifier = Modifier.clickable { navController.navigate("wallet") },
                    color = Color.White
                )
            }
        }
    }
}
