package pl.daftacademy.androidlevelup

import android.app.Application
import android.os.Build
import com.google.firebase.iid.FirebaseInstanceId
import pl.daftacademy.androidlevelup.util.NotificationFactory
import pl.daftacademy.androidlevelup.util.ext.fromAndroid
import pl.daftacademy.androidlevelup.util.ext.logd

private val TAG_FCM_TOKEN = "FCM Token"

class LevelUpApp : Application() {

    private val notificationFactory by lazy { NotificationFactory() }

    override fun onCreate() {
        super.onCreate()
        initCloudMessaging()
    }

    private fun initCloudMessaging() {
        fromAndroid(Build.VERSION_CODES.O) { notificationFactory.createNotificationChannels(this) }
        printCloudMessagingToken()
    }

    private fun printCloudMessagingToken() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnSuccessListener { it.token.logd(TAG_FCM_TOKEN) }
            .addOnFailureListener { it.printStackTrace() }
    }
}