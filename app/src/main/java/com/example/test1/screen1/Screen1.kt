package com.example.test1.screen1

import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.test1.data.setComboBoxSelectedOptionText
import com.example.test1.navhost.Screen
import java.util.Locale

@Composable
@Preview
fun Screen1(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android 1",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val text = "Hello $name! How is your day now? mine is perfect, thanks for asking buddy, we need to go shopping so lets hurry or we get late to make the dinner in time! cmone lets hurry spiderman its almost time, look! Its a Cloud, a wonderful one!"
    var tts : TextToSpeech? = null
    Column {
        Text(
            text = text,
            modifier = modifier.clickable {
            //    navController.navigate(route = Screen.Screen2.route)
            }
        )
        // ComboBox
        val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
        var expanded by remember { mutableStateOf(false) }
        var selectedOptionText by remember { mutableStateOf(options[0]) }

        val context = LocalContext.current

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                modifier = Modifier.menuAnchor(),
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("Label") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(text = selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            setComboBoxSelectedOptionText(selectionOption)
                            expanded = false
                        }
                    )
                }
            }
        }

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier,
            onClick = {
                tts = TextToSpeech(context) {

                    if (it == TextToSpeech.SUCCESS) {
                        val charSequence: CharSequence = text

                        tts?.setLanguage(Locale.ENGLISH)
                        tts?.setSpeechRate(1.0f)
                        tts?.setPitch(1.5f)
                     //   tts?.setVoice(selectedVoice)
                        if (tts?.isSpeaking == false || tts?.isSpeaking != null){
                            Log.d("add", "New readi speech")
                        tts?.speak(charSequence, TextToSpeech.QUEUE_ADD, null,"")
                        }
                    }
                }
            }) {

            Text(text = "Click me!")
        }
    } // Fin Column
}

