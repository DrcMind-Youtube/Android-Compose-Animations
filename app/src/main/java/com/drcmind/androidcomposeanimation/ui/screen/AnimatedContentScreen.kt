package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun AnimatedContentScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        var clickedNumber by remember {
            mutableIntStateOf(0)
        }
        Column(modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally) {
            AnimatedContent(
                targetState = clickedNumber,
                transitionSpec = {
                     slideIntoContainer(
                         towards = AnimatedContentTransitionScope.SlideDirection.Up,
                         animationSpec = tween(durationMillis = 1000)
                     ) togetherWith
                        slideOutOfContainer(
                            towards = AnimatedContentTransitionScope.SlideDirection.Up,
                            animationSpec = tween(durationMillis = 1000)
                        )
                },
                label = ""
            ) {targetState ->
                Text(text = "$targetState", fontSize = 50.sp, fontWeight = FontWeight.ExtraBold)
            }
            Button(onClick = { clickedNumber++ }) {
                Text(text = "Incrementer")
            }
        }
    }
}