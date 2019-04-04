package pl.daftacademy.androidlevelup.feature.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_service.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.util.ext.logd

class ServiceActivity : AppCompatActivity(), ServiceConnection {

    private val TAG = "ServiceActivity"
    private var serviceBinder: ExampleBoundService.Binder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnStartBackground.setOnClickListener {
            startService(Intent(this, ExampleBackgroundService::class.java))
        }
        btnStopBackground.setOnClickListener {
            stopService(Intent(this, ExampleBackgroundService::class.java))
        }
        btnStartForeground.setOnClickListener {
            ContextCompat.startForegroundService(this, Intent(this, ExampleForegroundService::class.java))
        }
        btnStopForeground.setOnClickListener {
            stopService(Intent(this, ExampleForegroundService::class.java))
        }
        btnStartIntent.setOnClickListener {
            startService(Intent(this, ExampleIntentService::class.java))
        }
        btnBind.setOnClickListener {
            bindService(Intent(this, ExampleBoundService::class.java), this, Context.BIND_AUTO_CREATE)
        }
        btnUnbind.setOnClickListener {
            unbindService(this)
        }
    }

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        serviceBinder = service as? ExampleBoundService.Binder
        "onServiceConnected()".logd(TAG)
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        "onServiceDisconnected()".logd(TAG)
    }

}