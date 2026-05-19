package com.example.practice.ui.screen.generator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice.data.storage.ImageStorage
import com.example.practice.viewmodel.GeneratorViewModel

@Composable
fun GeneratorScreen(viewModel: GeneratorViewModel = viewModel())
{

    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        TextField(value = text,
            onValueChange = { text = it },
            label = { Text("Введите текст") })

        Button(onClick = {
            viewModel.generate(text)
        }) {
            Text("Создать")
        }

        viewModel.bitmap?.let {
            Image(bitmap = it.asImageBitmap(),
                contentDescription = null)

            Button(onClick = {
                ImageStorage.save(context, it)
            }) {
                Text("Сохранить")
            }
        }
    }
}
