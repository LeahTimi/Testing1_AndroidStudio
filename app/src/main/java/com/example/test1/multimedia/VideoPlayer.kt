package com.example.test1.multimedia

import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.util.Log
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.annotation.OptIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView


// Dependencia Agregada

var url = "https://www.youtube.com/watch?v=YMEblRM4pGc"
val url2 = "app/src/main/java/com/example/test1/documents/testinku.mp4"
var url3 = "https://www.youtube.com/watch?v=4vqt9eYSJMo"
val url4 = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
val url5 = "https://firebasestorage.googleapis.com/v0/b/timonedaconazucar.appspot.com/o/temp1%2Ftestinku.mp4?alt=media&token=9a4dacfd-7098-45b4-95e9-bf72ddafb32f"
@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(url: String, full: MutableState<Boolean>) {
    val context = LocalContext.current

    val player = remember { ExoPlayer.Builder(context).build() }
    val playerView =  remember { PlayerView(context) }

    // Bind the player to the view.
    playerView.player = player
    // Build the media item.
    val mediaItem = MediaItem.fromUri(url5)
    // Set the media item to be played.
    player.setMediaItem(mediaItem)
    // Prepare the player.
    player.prepare()
    // Start the playback.
    // player.play()

        AndroidView(
            factory = { context ->
                playerView.apply {
                    // FullScreen Button
                    setFullscreenButtonClickListener { isFullscreen ->
                        val activity = context.findActivity()
                        if (isFullscreen) {
                            activity?.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                        } else {
                            activity?.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                        }
                    }

                    setOnClickListener {
                        full.value = !full.value
                        Log.d("Lemon","Clicked!")
                    }

                    // Creo que no es necesario
                    showController()
                    useController = true
                    // ------------------------
                    isSoundEffectsEnabled = true
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                    layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
                    clipToOutline = true
                }
            },
            modifier = Modifier.fillMaxSize()
        )
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