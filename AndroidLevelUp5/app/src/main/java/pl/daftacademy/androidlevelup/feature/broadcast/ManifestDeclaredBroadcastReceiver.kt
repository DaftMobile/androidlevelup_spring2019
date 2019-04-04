package pl.daftacademy.androidlevelup.feature.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import pl.daftacademy.androidlevelup.util.ext.logd

class ManifestDeclaredBroadcastReceiver : BroadcastReceiver() {

    private val TAG = "ManiBroadcastReceiver"

    override fun onReceive(context: Context, intent: Intent) {
        "Action: ${intent.action}".logd(TAG)
        Toast.makeText(context, intent.action, Toast.LENGTH_SHORT).show()
    }
}