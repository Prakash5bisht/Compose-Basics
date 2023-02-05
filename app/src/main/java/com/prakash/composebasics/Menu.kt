package com.prakash.composebasics

import android.view.Menu
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Menu(navController: NavController) {
    val scrollState = rememberScrollState()
    val menuItems = listOf<String>("ImageCard")
    val green = Color(0xff1DB954)
    val black = Color.Black
    val modifier = Modifier.padding(8.dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { navController.navigate(Screens.ImageCardScreen.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = green)
        ) {
            Text(text = "ImageCard", color = black, modifier = modifier)
        }
        Button(
            onClick = { navController.navigate(Screens.LazyColumnScreen.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = green)
        ) {
            Text(text = "LazyColumn", color = black, modifier = modifier)
        }
        Button(
            onClick = { navController.navigate(Screens.SnackBarScreen.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = green)
        ) {
            Text(text = "SnackBar", color = black, modifier = modifier)
        }
        Button(
            onClick = { navController.navigate(Screens.StateScreen.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = green)
        ) {
            Text(text = "State", color = black, modifier = modifier)
        }
        Button(
            onClick = { navController.navigate(Screens.SimpleAnimationScreen.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = green)
        ) {
            Text(text = "Simple Animation", color = black, modifier = modifier)
        }
        Button(
            onClick = { navController.navigate(Screens.AnimatedCircularProgressBar.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = green)
        ) {
            Text(text = "AnimatedCircularProgressBar", color = black, modifier = modifier)
        }
    }
}