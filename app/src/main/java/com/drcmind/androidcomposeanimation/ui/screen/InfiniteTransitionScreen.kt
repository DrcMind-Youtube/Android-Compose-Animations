package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun InfiniteTransitionScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        val infiniteTransition = rememberInfiniteTransition(label = "infinite")

        val size by infiniteTransition.animateValue(
            initialValue = 20.dp,
            targetValue = 200.dp,
            typeConverter = Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    durationMillis = 500
                    20.dp at 800
                    100.dp at 1000 with FastOutSlowInEasing

                }
            ), label = ""
        )

        val color by infiniteTransition.animateColor(
            initialValue = Color.Red,
            targetValue = Color.Green,
            animationSpec = infiniteRepeatable(
                animation = tween(500, easing = LinearEasing)
            ),
            label = "color"
        )

        Box(modifier = Modifier
            .background(color)
            .size(size)
        )
    }
}