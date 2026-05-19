package com.example.practice.data.qr

import android.graphics.Bitmap
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.BarcodeFormat
import android.graphics.Color

object QrGenerator
{
    fun generate(text: String): Bitmap
    {

        val writer = QRCodeWriter()
        val matrix = writer.encode(text,
            BarcodeFormat.QR_CODE, 512, 512)

        val bmp = Bitmap.createBitmap(512, 512, Bitmap.Config.RGB_565)

        for (x in 0 until 512)
        {
            for (y in 0 until 512)
            {
                bmp.setPixel(x, y,
                    if (matrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }

        return bmp
    }
}