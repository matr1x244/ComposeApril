package com.example.composeapril

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeapril.navigation.NavigationUserScreenDetail
import com.example.composeapril.navigation.NavigationUsers
import com.example.composeapril.ui.theme.ComposeAprilTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAprilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * Navigation default compose
                     */
//                    NavigationUser() // вариант без navigation menu default google :(
                    NavigationUserDefault() // вариант c navigation menu default google :)
                }
            }
        }
    }

    @Composable
    private fun NavigationUser() {
        var route by remember { mutableStateOf("NavigationUsers") }

        Column() {
            Row(modifier = Modifier.weight(1f)) {
                when (route) {
                    "NavigationUsers" -> NavigationUsers(
                        onUser100Click = { route = "user/1" },
                        onUser200Click = { route = "user/2" }
                    )

                    "user/1" -> NavigationUserScreenDetail("1")
                    "user/2" -> NavigationUserScreenDetail("2")
                }
            }

            Text(
                text = "Users Back home sreeen",
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable { route = "NavigationUsers" }
            )
        }
    }

    @Composable
    private fun NavigationUserDefault(){
        Column(modifier = Modifier.fillMaxSize()) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "NavigationUsers",
                modifier = Modifier.weight(1f)
            ) {
                composable("NavigationUsers") { NavigationUsers (
                    onUser100Click = { navController.navigate("user/1") },
                    onUser200Click = { navController.navigate("user/2") }
                ) }
                composable(
                    route = "user/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) {
                    val userId = it.arguments?.getString("id")
                    NavigationUserScreenDetail(userId)
                }
            }

            Text(
                text = "Users Back home sreeen",
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable { navController.navigate("NavigationUsers") }
            )
        }

    }

}

