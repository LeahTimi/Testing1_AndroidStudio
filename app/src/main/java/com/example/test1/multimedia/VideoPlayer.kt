package com.example.test1.multimedia

import android.content.res.Configuration
import android.hardware.SensorManager
import android.net.Uri
import android.util.Log
import android.view.SurfaceView
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
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
    val player = ExoPlayer.Builder(context).build()

//    val playerView = remember { PlayerView(context) }
    val playerView =  PlayerView(context)
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
    // -> https://github.com/google/ExoPlayer/issues/1845
    // -> https://geoffledak.com/blog/2017/09/11/how-to-add-a-fullscreen-toggle-button-to-exoplayer-in-android/

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color.Black)
        .rotate(
            if (full.value){
                90f
            } else {
                0f
            }
        )
        ){

        AndroidView(
            factory = { context ->
                PlayerView(context).apply {
                    this.player=player
                    isSoundEffectsEnabled = true
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                    if (full.value){
                    layoutParams = FrameLayout.LayoutParams(500, 500)
                    }else {

                    }
                    clipToOutline = true
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

// findViewById(Window.ID_ANDROID_CONTENT)


@Composable
fun VideoPaleilo() {
    val context = LocalContext.current
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(Uri.parse(url4))
    exoPlayer.setMediaItem(mediaItem)


    val playerView = PlayerView(context)
    playerView.player = exoPlayer

    DisposableEffect(
        AndroidView(factory = {playerView})
    ){

        exoPlayer.prepare()
        exoPlayer.playWhenReady= true

        onDispose {
            exoPlayer.release()
        }
    }
}