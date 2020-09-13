package com.nasikhunamin.servicesample

import android.app.IntentService
import android.content.Intent
import android.util.Log
import kotlinx.coroutines.delay


class MyIntentService : IntentService("MyIntentService") {
    
    companion object {
        internal val EXTRA_DURATION = "extra_duration"
        private val TAG = MyIntentService::class.java.name
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "onHandleIntent: Mulai..")
        val duration = intent?.getLongExtra(EXTRA_DURATION, 0) as Long
        try {
            Thread.sleep(duration)
            Log.d(TAG, "onHandleIntent: Selesai..")
        }catch (ex: InterruptedException){
            ex.printStackTrace()
            Thread.currentThread().interrupt()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }


}
