package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun UpdateTransitionScreen(){

    var isLarge by remember {
        mutableStateOf(true)
    }

    val transition = updateTransition(targetState = isLarge, label = null)

    val size by transition.animateDp(label = "") {state ->
        when (state){
            false -> 100.dp
            true -> 300.dp
        }
    }
    val color by transition.animateColor(label = "") {state ->
        when (state){
            false -> Cyan
            true -> Green
        }
    }


    Box(modifier = Modifier.fillMaxSize()){
        transition.AnimatedVisibility(
            visible = {isLarge},
            modifier = Modifier.align(Alignment.Center)
        ) {
            Box(modifier = Modifier
                .align(Alignment.Center)
                .background(color)
                .size(size)
            )
        }


        Button(
            onClick = {
            isLarge = !isLarge
        },
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text(text = "Action")
        }
    }
}