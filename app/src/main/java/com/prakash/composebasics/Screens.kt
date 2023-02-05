package com.prakash.composebasics

sealed class Screens(val route: String){
    object MenuScreen : Screens("menu_screen")
    object ImageCardScreen : Screens("image_card_screen")
    object StateScreen : Screens("state_screen")
    object LazyColumnScreen : Screens("lazy_column_screen")
    object SnackBarScreen : Screens("snack_bar_screen")
    object SimpleAnimationScreen : Screens("simple_animation_screen")
    object AnimatedCircularProgressBar : Screens("animated_circular_progressBar_screen")
}