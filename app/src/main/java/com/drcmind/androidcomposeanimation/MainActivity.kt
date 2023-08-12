package com.drcmind.androidcomposeanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drcmind.androidcomposeanimation.ui.screen.AnimatableScreen
import com.drcmind.androidcomposeanimation.ui.screen.AnimateAppearenceScreen
import com.drcmind.androidcomposeanimation.ui.screen.AnimateContentSizeScreen
import com.drcmind.androidcomposeanimation.ui.screen.AnimatedContentScreen
import com.drcmind.androidcomposeanimation.ui.screen.AnimatedImageVectorScreen
import com.drcmind.androidcomposeanimation.ui.screen.InfiniteTransitionScreen
import com.drcmind.androidcomposeanimation.ui.screen.LottieAnimationScreen
import com.drcmind.androidcomposeanimation.ui.screen.UpdateTransitionScreen
import com.drcmind.androidcomposeanimation.ui.theme.AndroidComposeAnimationTheme

class MainActivity : ComponentActivity() {

    val animScreens = listOf("AnimatedImageVector", "LottieAnimation","InfiniteTransition",
        "UpdateTransition", "Animatable", "AnimateAppearence", "AnimateContentSize", "AnimateContent"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComposeAnimationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var isExpanded by remember {
                        mutableStateOf(false)
                    }

                    val navController = rememberNavController()

                    Box(Modifier.fillMaxSize()) {
                        Box(modifier = Modifier.align(Alignment.BottomStart)){
                            IconButton(onClick = { isExpanded = !isExpanded }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = null
                                )
                                DropdownMenu(
                                    expanded = isExpanded,
                                    onDismissRequest = { isExpanded = false }) {
                                    animScreens.forEachIndexed { index, string ->
                                        DropdownMenuItem(
                                            text = { Text(text = string) },
                                            onClick = {
                                                navController.navigate("route${index+1}")
                                                isExpanded = false
                                            })
                                    }
                                }
                            }
                        }

                        NavHost(navController = navController, startDestination = "route1"){
                            composable(
                                "route1",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }
                            ){
                                AnimatedImageVectorScreen()
                            }
                            composable("route2",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }){
                                LottieAnimationScreen()
                            }
                            composable("route3",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }){
                                InfiniteTransitionScreen()
                            }
                            composable("route4",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }){
                                UpdateTransitionScreen()
                            }
                            composable("route5",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }){
                                AnimatableScreen()
                            }
                            composable("route6",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }){
                                AnimateAppearenceScreen()
                            }
                            composable("route7",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }){
                                AnimateContentSizeScreen()
                            }
                            composable("route8",
                                enterTransition = { slideInHorizontally(initialOffsetX = { -1000 }) },
                                exitTransition = { slideOutHorizontally(targetOffsetX = { 1000 }) }){
                                AnimatedContentScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}