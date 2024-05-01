package com.example.composeapril

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composeapril.ui.theme.ComposeAprilTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeAprilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    animatedEffect()
                    derivedStateOf() //Урок 19
//                    snapshotFlow()
                }
            }
        }
    }

    private fun snapshotFlow() {
        TODO("Not yet implemented")
    }


    /**
     * derivedStateOf
    Функция derivedStateOf умеет создавать State, который читает значения из других State и подписывается на них.
     */
    @Composable
    private fun derivedStateOf() {
        Column {
            var count by remember { mutableStateOf(0) }
            Text(text = "count = $count", modifier = Modifier.clickable { count++ })

            val countBinary by remember { derivedStateOf { count.toString(2) } }
            Text(text = "countBinary = $countBinary")
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    private fun animatedEffect() {
        var visible by remember { mutableStateOf(true) }
        val commentsAlpha = if (visible) 1f else 0.2f

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
        ) {

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(shape = CircleShape)
                        .animateEnterExit(enter = expandVertically(), exit = shrinkHorizontally()),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "IMAGE",
                    contentScale = ContentScale.None
                )
            }

            AnimatedVisibility(visible = visible, enter = fadeIn(),exit = fadeOut()) {
                Button(modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp), onClick = { visible = !visible }) {
                    Text(text = "Toggle Visibility")
                }
            }
            Text(textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .height(32.dp)
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .alpha(commentsAlpha)
                    .clickable { visible = !visible },
                text = "Text Testing"
            )
        }
    }

}

