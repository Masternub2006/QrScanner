package com.example.practice.navigatoin

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.ui.components.BottomBar
import com.example.practice.ui.screen.generator.GeneratorScreen
import com.example.practice.ui.screen.scanner.ScannerScreen

@Composable
fun AppNavGraph()
{
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomBar(navController) })
    {
        padding ->
        NavHost(navController = navController, startDestination = "scanner", modifier = Modifier.padding(padding))
        {
            composable("scanner") { ScannerScreen() }
            composable("generator") { GeneratorScreen() }
        }
    }
}