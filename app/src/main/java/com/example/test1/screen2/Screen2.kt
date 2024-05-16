package com.example.test1.screen2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.test1.data.getComboBoxSelectedOptionText
import com.example.test1.multimedia.VideoPlayer
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
    val full = remember {
        mutableStateOf(true)
    }
    Column {
        if (full.value){
            Text(
                text = "Hello $name!",
                modifier = modifier.clickable {
                    navController.navigate(route = Screen.Screen1.route)
                }
            )
        }
        VideoPlayer("",full)
    }
}



@Composable
@Preview
fun Screen2Preview(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        GreetingPreview(
            name = "Android 2",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
@Composable
fun GreetingPreview(name: String,modifier: Modifier = Modifier) {
    val option = getComboBoxSelectedOptionText()
    Column {
        Text(
            text = "Hello $name!",
            modifier = Modifier
        )
        Text(
            text = "You Clicked -> $option"
        )
    }
}