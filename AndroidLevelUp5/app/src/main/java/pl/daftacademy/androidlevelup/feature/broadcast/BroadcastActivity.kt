package pl.daftacademy.androidlevelup.feature.broadcast

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_broadcast.*
import pl.daftacademy.androidlevelup.R

const val BROADCAST_EXTRA = "BROADCAST_EXTRA"
const val BROADCAST_ACTION = "pl.daftacademy.androidlevelup.NOTIFY"

class BroadcastActivity : AppCompatActivity() {

    private val receiver = ContextRegisteredBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)
        btnSend.setOnClickListener {
            Intent(BROADCAST_ACTION)
                .putExtra(BROADCAST_EXTRA, "LevelUp!")
                .let { sendBroadcast(it) }
        }
    }

    override fun onResume() {
        super.onResume()
        IntentFilter().apply {
            addAction(BROADCAST_ACTION)
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        }.let { registerReceiver(receiver, it) }
    }

    override fun onPause() {
        unregisterReceiver(receiver)
        super.onPause()
    }
}