package com.example.practice.viewmodel

import android.graphics.Bitmap
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.practice.data.qr.QrGenerator


class GeneratorViewModel : ViewModel()
{

    var bitmap by mutableStateOf<Bitmap?>(null)
        private set

    fun generate(text: String)
    {
        bitmap = QrGenerator.generate(text)
    }
}