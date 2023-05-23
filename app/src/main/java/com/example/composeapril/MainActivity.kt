package com.example.composeapril

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                    sliderPosition()
                }
            }
        }
    }


    /**
     * Получилось следующее:
    - remember хранит для нас State
    - при каждом движении слайдера, идет вызов функции TrackPosition и мы пишем актуальное значение позиции слайдера в State
    - корутина в LaunchedEffect раз в секунду читает актуальное значение позиции слайдера из State и выводит данные
     */

    @Composable
    private fun sliderPosition() {
        Column {
            var sliderPosition by remember { mutableStateOf(1f) }

            Slider(
                value = sliderPosition,
                valueRange = 1f..10f,
                onValueChange = { sliderPosition = it })

            TrackPosition(position = sliderPosition)
            Text(text = sliderPosition.toString())
        }
    }

    private @Composable
    fun TrackPosition(position: Float) {
        val positionState = remember { mutableStateOf(position) }
        positionState.value = position

        LaunchedEffect(key1 = Unit) {
            while(true) {
                delay(1000)
                println("@@@@ track position ${positionState.value}")
            }
        }
    }


}

