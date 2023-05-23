package com.example.composeapril

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composeapril.ui.theme.ComposeAprilTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAprilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    sideEffect()
                }
            }
        }
    }


    /**
     * Функция SideEffect гарантирует, что код будет выполнен только в случае успешного выполнения Composable кода.
     * Если же что-то пошло не так, что SideEffect не выполнится.
     */

    /**
     * При включении чекбокса мы дважды пишем в лог, а потом бросаем исключение.
     * Но первая запись в лог сделана в Composable коде, а вторая - в функции SideEffect.
     */
    @Composable
    private fun sideEffect() {
        Column {
            var checked by remember { mutableStateOf(false) }
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            if (checked) {
               println("@@@@ HomeScreen log")
                SideEffect {
                    print("@@@@ HomeScreen log in SideEffect")
//                    val a = 1/ 0
                }
            }
        }
    }

}

