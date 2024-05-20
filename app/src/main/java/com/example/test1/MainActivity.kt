package com.example.test1

import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test1.extras.VideoPlayer
import com.example.test1.extras.findActivity
import com.example.test1.extras.setScreenOrientation
import com.example.test1.navhost.Navigation
import com.example.test1.navhost.Screen
import com.example.test1.ui.theme.Test1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Test1Theme {
                Navigation()
            }
        }
    }
}
@Composable
fun VideoTest(){
    val full = remember {
        mutableStateOf(true)
    }
    val context = LocalContext.current
    val activity = context.findActivity()

    Log.d("Lemon", activity?.requestedOrientation.toString())
    Column(modifier = Modifier.fillMaxSize()) {
        if (full.value && activity?.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            predefiniedTopBar("hey You")
        }
        VideoPlayer(full)
    }
}

// Extension function to find the current activity
fun Context.findActivity(): ComponentActivity? {
    var currentContext = this
    while (currentContext is ContextWrapper) {
        if (currentContext is ComponentActivity) {
            return currentContext
        }
        currentContext = currentContext.baseContext
    }
    return null
}

// Extension function to set screen orientation
fun Context.setScreenOrientation(orientation: Int) {
    val activity = findActivity()
    activity?.requestedOrientation = orientation
}

// TOP BAR With out Return Statement
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun predefiniedTopBar( topBarText : String){
    CenterAlignedTopAppBar(
        title = {
            Row (modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Log.d("Lemon", "Salisteeeee")
                },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Text(text = topBarText,
                    textAlign = TextAlign.Center,
                    fontSize = 26.sp,
                    color = Color.White, fontFamily = FontFamily.Monospace)
                Spacer(modifier = Modifier.width(1.dp))
            } // Row
        }, // Title
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black)
        // #A67ABD
    )
}