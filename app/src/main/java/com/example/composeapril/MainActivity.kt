package com.example.composeapril

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapril.navigation.NavigationUserScreenDetail
import com.example.composeapril.navigation.NavigationUsers
import com.example.composeapril.ui.theme.ComposeAprilTheme
import com.example.composeapril.viewmodel.UsersSharedViewModel

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
                    val activity = LocalViewModelStoreOwner.current
                    NavigationUserDefault() // вариант c navigation menu default google :)
                }
            }
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
                    onUserClick = { navController.navigate("user") },
                ) }
                composable("user") { backStackEntry ->
                    val activity = checkNotNull(LocalViewModelStoreOwner.current)
                    val userEntry = remember (backStackEntry){
                        navController.getBackStackEntry("NavigationUsers")
                    }
                    NavigationUserScreenDetail(
                        "$id",
                        usersSharedViewModel = viewModel(activity)
                    )
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

