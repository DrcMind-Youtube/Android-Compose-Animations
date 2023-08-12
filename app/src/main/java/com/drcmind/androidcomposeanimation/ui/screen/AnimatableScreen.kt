package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun AnimatableScreen(){

    val scope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val width = remember {
        Animatable(
            initialValue = 0.dp,
            typeConverter = Dp.VectorConverter
        )
    }

    Box(modifier = Modifier.fillMaxSize()){
        Box(modifier = Modifier
            .height(50.dp)
            .width(width.value)
            .background(Color.Green)
            .align(Alignment.CenterStart)
        )
        Button(
            onClick = {
                scope.launch {
                    width.animateTo(
                        targetValue = screenWidth,
                        animationSpec = keyframes {
                            durationMillis = 2000
                            screenWidth/2 to 500
                        }
                    )
                }
            },
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Text(text = "Action")
        }
    }
}