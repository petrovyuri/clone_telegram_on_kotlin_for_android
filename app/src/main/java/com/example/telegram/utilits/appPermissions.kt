package com.example.telegram.utilits

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/* Файл для работы с разрешениями*/

const val READ_CONTACTS = Manifest.permission.READ_CONTACTS
const val RECORD_AUDIO = Manifest.permission.RECORD_AUDIO
const val WRITE_FILES = Manifest.permission.WRITE_EXTERNAL_STORAGE

const val PERMISSION_REQUEST = 200

fun checkPermission(permission: String): Boolean {
    /* Функция принимает разрешение и проверяет, если разрешение еще не было
    * предоставлено запускает окно с запросом пользователю */
    return if (Build.VERSION.SDK_INT >= 23
        && ContextCompat.checkSelfPermission(
            APP_ACTIVITY,
            permission
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(APP_ACTIVITY, arrayOf(permission), PERMISSION_REQUEST)
        false
    } else true
}