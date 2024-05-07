package com.example.test1.Screen2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.test1.data.getComboBoxSelectedOptionText
import com.example.test1.navhost.Screen

@Composable
fun Screen2(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android 2",
            modifier = Modifier.padding(innerPadding),
            navController = navController
        )
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,navController: NavController) {
    val option = getComboBoxSelectedOptionText()
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier.clickable {
                navController.navigate(route = Screen.Screen1.route)
            }
        )
        Text(
            text = "You Clicked -> $option",
            modifier = modifier.clickable {
                navController.navigate(route = Screen.Screen1.route)
            }
        )
    }
}