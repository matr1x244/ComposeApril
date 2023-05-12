package com.example.composeapril.navigation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapril.viewmodel.UsersSharedViewModel

@Composable
fun NavigationUserScreenDetail(
    id: String?,
    usersSharedViewModel: UsersSharedViewModel = viewModel()
) {
    Text(text = "User $id OPEN")
    Log.d(TAG,"@@@@ user $id")
    Log.d(TAG,"@@@@ viewModel ${usersSharedViewModel.hashCode()}")
    Log.d(TAG,"@@@@ viewModelStoreOwner ${LocalViewModelStoreOwner.current?.javaClass?.simpleName}")

    /**
     * Смотреть log.d: "@@@@ viewModelStoreOwner"
     * NavBackStackEntry - это сущность навигации.
     * Когда мы с помощью NavController открываем новый экран,
     * для этого экрана создается NavBackStackEntry и помещается в BackStack.
     */
}