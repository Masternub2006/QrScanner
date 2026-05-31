package com.example.practice.ui.screen.scanner

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.practice.data.qr.QrScanner

@Composable
fun ScannerScreen()
{

    val context = LocalContext.current
    var result by remember { mutableStateOf("") }

    var permissionDenied by remember {
        mutableStateOf(false)
    }

    val scanner = remember {
        QrScanner(context)
    }

    val cameraPermissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission())
        {
            granted ->
            if (granted)
            {
                scanner.startScan {
                    result = it
                }
            }
            else
            {
                permissionDenied = true
            }
        }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Button(onClick =
        {
            val permissionCheck = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
            if (permissionCheck == PackageManager.PERMISSION_GRANTED)
            {
                scanner.startScan {
                    result = it
                }
            }
            else
            {
                cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        })
        {

            Text("Сканировать")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(result)

        if (permissionDenied)
        {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Разрешение на камеру отклонено")
        }
    }
}