// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun buildMsg(txt: String): String = "Hello, $txt"
@Composable
@Preview
fun App() {
    val text = remember { mutableStateOf("") }
    val buttonEnabled = text.value.isNotEmpty()
    MaterialTheme {
        Column {
            TextField(value = text.value, onValueChange = { newText -> text.value = newText })
            Text(text = buildMsg(text.value))
            Button(onClick = { text.value = "" }, enabled = buttonEnabled ) {
                Text("Clean")
            }
        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
