package com.example.composeapril

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.composeapril.rememberObserver.RememberObserverTestingLifeCycle
import com.example.composeapril.ui.theme.ComposeAprilTheme
import kotlinx.coroutines.delay
import java.util.Date

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAprilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ComposableLifecycle()
                }
            }
        }
    }

    @Composable
    private fun ComposableLifecycle() {
        Column {
            var checked by remember { mutableStateOf(false) }
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            val homeTime = remember { currentTime() }
            val rememberObserverTestingLifeCycle = remember { RememberObserverTestingLifeCycle() }
            if (checked) {
                val timeScreenStopReally = remember { currentTime() }
                val rememberObserverTestingLifeCycle =
                    remember { RememberObserverTestingLifeCycle() }
                Text("val homeTime Start = $homeTime \n time Really Screen = $timeScreenStopReally")
                ClickCounter()

                DisposableEffect(key1 = Unit) {
                    /**
                     * Функция DisposableEffect так же, как и LaunchedEffect, позволяет выполнить код один раз при первом вызове Composable кода.
                     * Но есть пара отличий. Код будет выполнен не в корутине. И у нас есть возможность повесить свой колбэк на onForgotten.
                     * Т.е. эта функция подходит, когда нам нужно подписаться на что-либо при старте экрана, а при закрытии - отписаться.
                     */
                    var counter = 0
                    onDispose {
                        while (true) {
                            println("@@@@@ LaunchedEffect counter job = ${counter++}")
                        }
                    }
                }
            }
        }

    }

    @Composable
    fun BroadcastReceiver(intentFilter: IntentFilter, onReceive: (Intent) -> Unit) {
        val context = LocalContext.current
        DisposableEffect(context) {
            val broadcastReceiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    onReceive(intent)
                }
            }
            context.registerReceiver(broadcastReceiver, intentFilter)
            onDispose {
                context.unregisterReceiver(broadcastReceiver)
            }
        }
    }

    @Composable
    fun ClickCounter() {
        var count by remember { mutableStateOf(0) }
        Text(
            text = "Count $count",
            modifier = Modifier.clickable { count++ }
        )
    }

    private fun currentTime(): String {
        return SimpleDateFormat("HH:mm:ss").format(Date())
    }

}

