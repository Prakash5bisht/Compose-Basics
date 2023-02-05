package com.prakash.composebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun ColorBox(navController: NavController) {
    val color = remember{ mutableStateOf(Color.Yellow) }

    Box(
        modifier = Modifier
            .background(color.value)
            .width(200.dp)
            .height(200.dp)
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Click", color = Color.White)
    }
}