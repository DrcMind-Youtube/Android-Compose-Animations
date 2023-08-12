package com.drcmind.androidcomposeanimation.ui.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContentSizeScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Card(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                    "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                    "ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                    "Duis aute irure dolor in reprehenderit in voluptate velit " +
                    "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
                    "occaecat cupidatat non proident, sunt in culpa qui officia " +
                    "deserunt mollit anim id est laborum",
                maxLines = if (isExpanded) 15 else 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
                    .padding(8.dp)
                    .animateContentSize(
                        animationSpec = tween(durationMillis = 500)
                    )
                )
        }
    }
}