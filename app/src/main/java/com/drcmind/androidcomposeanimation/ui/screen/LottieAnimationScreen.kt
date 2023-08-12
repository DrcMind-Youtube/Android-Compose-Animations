package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.drcmind.androidcomposeanimation.R

@Composable
fun LottieAnimationScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.walking_anim)
        )

        var speed by remember {
            mutableFloatStateOf(1f)
        }

        val progress by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            speed = speed
        )

        Column(Modifier.fillMaxWidth()) {
            Row {
                Button(onClick = {
                    speed--
                }) {
                    Text(text = "Ralentir")
                }
                Button(onClick = {
                    speed++
                }) {
                    Text(text = "Accélerer")
                }
            }
            LottieAnimation(
                composition = composition,
                progress = {progress}
            )
        }
    }
}