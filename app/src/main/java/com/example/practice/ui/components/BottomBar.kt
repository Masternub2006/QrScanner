package com.example.practice.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController)
{

    NavigationBar {
        NavigationBarItem(selected = false,
            onClick = { navController.navigate("scanner") },
            icon = { Icon(Icons.Default.Camera, null) },
            label = { Text("Сканер") })

        NavigationBarItem(selected = false,
            onClick = { navController.navigate("generator") },
            icon = { Icon(Icons.Default.Create, null) },
            label = { Text("Генератор") })
    }
}