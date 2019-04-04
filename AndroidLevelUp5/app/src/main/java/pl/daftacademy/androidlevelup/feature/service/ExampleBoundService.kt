package pl.daftacademy.androidlevelup.feature.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import pl.daftacademy.androidlevelup.util.ext.logd
import android.os.Binder as OsBinder

class ExampleBoundService : Service() {

    private val TAG = "ExampleBoundService"
    private val binder by lazy { Binder() }
    private var bindsCount = 0

    override fun onCreate() {
        super.onCreate()
        "onCreate($this)".logd(TAG)
        Thread.currentThread().logd(TAG)
    }

    override fun onDestroy() {
        super.onDestroy()
        "onDestroy($this)".logd(TAG)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        "onStartCommand()".logd(TAG)
        Thread.currentThread().logd(TAG)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        "onBind()".logd(TAG)
        Thread.currentThread().logd(TAG)
        showBindsToast()
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        "onUnbind()".logd(TAG)
        return super.onUnbind(intent)
    }

    class Binder : OsBinder() {
        fun getService() = this@Binder
    }

    private fun showBindsToast() {
        bindsCount += 1
        Toast.makeText(this, "Starts x$bindsCount", Toast.LENGTH_SHORT).show()
    }
}