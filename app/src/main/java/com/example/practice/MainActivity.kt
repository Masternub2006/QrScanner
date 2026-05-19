package com.example.practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.navigatoin.AppNavGraph
import com.example.practice.ui.screen.generator.GeneratorScreen

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavGraph()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview()
{
    GeneratorScreen()
}

