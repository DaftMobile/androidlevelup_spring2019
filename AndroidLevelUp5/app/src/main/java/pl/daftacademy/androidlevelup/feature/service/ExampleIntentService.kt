package pl.daftacademy.androidlevelup.feature.service

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import pl.daftacademy.androidlevelup.util.ext.logd

class ExampleIntentService : IntentService("ExampleIntentService") {

    private val TAG = "ExampleIntentService"

    override fun onCreate() {
        super.onCreate()
        "onCreate($this)".logd(TAG)
        Thread.currentThread().logd(TAG)
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy($this)".logd(TAG)
    }

    override fun onHandleIntent(intent: Intent?) {
        "onHandleIntent()".logd(TAG)
        Thread.currentThread().logd(TAG)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        "onStartCommand()".logd(TAG)
        Thread.currentThread().logd(TAG)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        "onBind()".logd(TAG)
        Thread.currentThread().logd(TAG)
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        "onUnbind()".logd(TAG)
        return super.onUnbind(intent)
    }
}