package com.example.practice.data.qr

import android.content.Context
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

class QrScanner(context: Context)
{

    private val scanner: GmsBarcodeScanner = GmsBarcodeScanning.getClient(context)

    fun startScan(onResult: (String) -> Unit)
    {
        scanner.startScan().addOnSuccessListener { barcode ->
            onResult(barcode.rawValue ?: "")
        }
    }
}