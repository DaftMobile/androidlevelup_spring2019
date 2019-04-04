package pl.daftacademy.androidlevelup.feature.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import pl.daftacademy.androidlevelup.util.ext.logd

class ContextRegisteredBroadcastReceiver : BroadcastReceiver() {

    private val TAG = "ContextBroadcastReceiver"

    override fun onReceive(context: Context, intent: Intent) {
        "Action: ${intent.action}".logd(TAG)
        Toast.makeText(context, intent.action, Toast.LENGTH_SHORT).show()
        when (intent.action) {
            BROADCAST_ACTION -> {
                "Extra: ${intent.getStringExtra(BROADCAST_EXTRA)}".logd(TAG)
                //todo: do something here
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                //todo: do something here
            }
        }
    }
}