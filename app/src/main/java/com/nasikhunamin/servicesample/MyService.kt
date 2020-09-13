package com.nasikhunamin.servicesample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MyService : Service() {

    companion object {
        internal val TAG = MyService::class.java.name
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service dijalankan")
        GlobalScope.launch {
            delay(3000L)
            stopSelf() // menghentikan service dari sistem android
            Log.d(TAG, "Service dihentikan")
        }
        return START_STICKY // menandakan bahwa bila service tersebut dimatikan oleh sistem Android karena kekurangan memori, ia akan diciptakan kembali jika sudah ada memori yang bisa digunakan.
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy:")
    }
}
