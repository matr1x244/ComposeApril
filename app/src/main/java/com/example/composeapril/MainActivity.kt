package com.example.composeapril

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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

                LaunchedEffect(key1 = Unit) {
                    /**
                     * "key" Функция LaunchedEffect на вход просит key.
                     * По исходникам видно, что этот key из LaunchedEffect передается в remember. Что это дает?
                     * При смене значения key, remember вызовет onForgotten для текущего объекта,
                     * создаст новый объект и вызовет у него onRemembered.
                     * Т.е. как будто мы убрали remember из Composition и поместили обратно.
                     * Таким образом старая корутина в LaunchedEffectImpl отменится, а новая стартует.
                     * Это может быть полезно, если мы извне получили новое значение и хотим заново стартовать корутину.
                     *
                     * Если вам такая опция не нужна, то просто передавайте в качестве key значение true, Unit, null или т.п.
                     */
                    /**
                     * "key" Функция LaunchedEffect на вход просит key.
                     * По исходникам видно, что этот key из LaunchedEffect передается в remember. Что это дает?
                     * При смене значения key, remember вызовет onForgotten для текущего объекта,
                     * создаст новый объект и вызовет у него onRemembered.
                     * Т.е. как будто мы убрали remember из Composition и поместили обратно.
                     * Таким образом старая корутина в LaunchedEffectImpl отменится, а новая стартует.
                     * Это может быть полезно, если мы извне получили новое значение и хотим заново стартовать корутину.
                     *
                     * Если вам такая опция не нужна, то просто передавайте в качестве key значение true, Unit, null или т.п.
                     */
                    var counter = 0
                    while (true) {
                        println("@@@@@ LaunchedEffect counter job = ${counter++}")
                        delay(1000)
                    }
                }
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

