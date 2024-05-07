package com.example.test1.navhost

sealed class Screen(val route: String) {
    object Screen1 : Screen("screen1_screen")
    object Screen2 : Screen("screen2_screen")
}