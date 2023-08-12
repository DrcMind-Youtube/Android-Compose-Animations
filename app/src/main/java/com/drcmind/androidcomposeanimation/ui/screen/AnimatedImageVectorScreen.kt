package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.drcmind.androidcomposeanimation.R

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimatedImageVectorScreen(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val image = AnimatedImageVector.animatedVectorResource(id = R.drawable.avd_anim)
        var atEnd by remember {
            mutableStateOf(false)
        }
        Image(
            painter = rememberAnimatedVectorPainter(animatedImageVector = image, atEnd = atEnd),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
                .clickable {
                    atEnd = !atEnd
                },
            contentScale = ContentScale.Crop
        )
    }
}