package com.example.practice.ui.screen.scanner

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.practice.data.qr.QrScanner

@Composable
fun ScannerScreen()
{

    val context = LocalContext.current
    var result by remember { mutableStateOf("") }

    val scanner = remember {
        QrScanner(context)
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Button(onClick = {
            scanner.startScan { result = it }
        }) {
            Text("Сканировать")
        }

        Text(result)

        if (result.startsWith("http"))
        {
            Button(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(result))
                context.startActivity(intent)
            }) {
                Text("Открыть")
            }
        }
    }
}