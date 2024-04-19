// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

class AppState {
    val text = mutableStateOf("")
    fun isButtonEnabled() = text.value.isNotEmpty()
    /*
    val buttonEnabled : Boolean
        get() = text.value.isNotEmpty()
        Modificando más adelante con enabled = appState.buttonEnabled
    }
     */
}

@Composable
@Preview
fun App(appState: AppState) {
    MaterialTheme {
        Column {
            TextField(value = appState.text.value, onValueChange = { newText -> appState.text.value = newText })
            Text(text = buildMessage(appState.text.value))
            Button(onClick = { appState.text.value = "" }, enabled = appState.isButtonEnabled()) {
                Text("Clean")
            }
        }

    }
}

fun buildMessage(ms: String): String = "Hello $ms"

fun main() {
    //Antes de llamar a Compose
    val apSt = AppState()
    //Llamando a Compose
    application {
        Window(onCloseRequest = ::exitApplication) {
            App(apSt)
        }
    }
}
