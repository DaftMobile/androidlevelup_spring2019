package pl.daftacademy.androidlevelup.feature.fcm

import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import pl.daftacademy.androidlevelup.util.ext.logd

class CloudMessagingService : FirebaseMessagingService() {

    private val TAG = "CloudMessagingService"

    override fun onNewToken(token: String) {
        //todo: send new token to your backend
        "Token: $token".logd(TAG)
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        super.onMessageReceived(message)
        //todo: handle message when app is in foreground
        message?.notification?.body?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
    }
}