package com.prakash.composebasics

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.MenuScreen.route){

        composable(route = Screens.MenuScreen.route){
            Menu(navController)
        }
        composable(route = Screens.ImageCardScreen.route){
            ImageCard(navController)
        }
        composable(route = Screens.StateScreen.route){
           ColorBox(navController)
        }
        composable(route = Screens.LazyColumnScreen.route){
           LazyColumn(navController)
        }
        composable(route = Screens.SnackBarScreen.route){
           SnackBar(navController)
        }
        composable(route = Screens.SimpleAnimationScreen.route){
           SimpleAnimation(navController)
        }
        composable(route = Screens.AnimatedCircularProgressBar.route){
            AnimatedCircularProgressBar(navController)
        }

    }
}