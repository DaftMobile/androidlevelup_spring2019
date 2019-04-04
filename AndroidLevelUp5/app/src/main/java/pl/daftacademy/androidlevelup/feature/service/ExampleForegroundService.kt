package pl.daftacademy.androidlevelup.feature.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import pl.daftacademy.androidlevelup.util.NotificationFactory
import pl.daftacademy.androidlevelup.util.ext.logd

private const val NOTIFICATION_ID = 997
private const val NOTIFICATION_TITLE = "Service Info"
private const val NOTIFICATION_BODY = "Service running..."

class ExampleForegroundService : Service() {

    private val TAG = "ExampleForegroundService"
    private val notificationFactory by lazy { NotificationFactory() }
    private var startsCount = 0

    override fun onCreate() {
        super.onCreate()
        "onCreate($this)".logd(TAG)
        Thread.currentThread().logd(TAG)
        startForeground(NOTIFICATION_ID, notificationFactory.create(this, NOTIFICATION_TITLE, NOTIFICATION_BODY))
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy($this)".logd(TAG)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        "onStartCommand()".logd(TAG)
        Thread.currentThread().logd(TAG)
        showStartsToast()
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

    private fun showStartsToast() {
        startsCount += 1
        Toast.makeText(this, "Starts x$startsCount", Toast.LENGTH_SHORT).show()
    }
}