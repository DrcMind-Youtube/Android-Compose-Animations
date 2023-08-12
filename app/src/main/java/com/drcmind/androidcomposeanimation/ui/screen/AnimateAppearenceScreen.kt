package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
import androidx.compose.ui.unit.dp

@Composable
fun AnimateAppearenceScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        var isVisible by remember {
            mutableStateOf(true)
        }
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(initialOffsetX = { 1000 }) + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = {-1000}) + fadeOut(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Box(modifier = Modifier
                .size(300.dp)
                .background(Color.Red))
        }
        
        Button(onClick = {
            isVisible = !isVisible
        },
            modifier = Modifier.align(Alignment.TopCenter)
            ) {
            Text(text = "Action")
        }
    }
}