package com.example.practice.data.storage

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.provider.MediaStore

object ImageStorage
{
    fun save(context: Context, bitmap: Bitmap)
    {

        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "qr_${System.currentTimeMillis()}.png")
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
        }

        val uri =
            context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        uri?.let {
            context.contentResolver.openOutputStream(it)?.use { stream ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            }
        }
    }
}