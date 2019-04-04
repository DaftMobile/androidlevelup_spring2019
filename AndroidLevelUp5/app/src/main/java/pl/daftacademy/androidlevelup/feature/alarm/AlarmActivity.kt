package pl.daftacademy.androidlevelup.feature.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alarm.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.feature.broadcast.ManifestDeclaredBroadcastReceiver
import pl.daftacademy.androidlevelup.util.ext.beforeAndroid
import pl.daftacademy.androidlevelup.util.ext.fromAndroid
import java.util.concurrent.TimeUnit

class AlarmActivity : AppCompatActivity() {

    private val alarmManager: AlarmManager
        get() = getSystemService(Context.ALARM_SERVICE) as AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        btnScheduleSingleAlarm.setOnClickListener { scheduleSingleAlarm() }
        btnSchedulePeriodicAlarm.setOnClickListener { schedulePeriodicAlarm() }
    }

    private fun scheduleSingleAlarm() {
        Intent(this, ManifestDeclaredBroadcastReceiver::class.java)
            .apply { action = "com.daftacademy.androidlevelup.NOTIFY" }
            .let { PendingIntent.getBroadcast(this, 0, it, 0) }
            .let {
                fromAndroid(Build.VERSION_CODES.N) {
                    alarmManager.setExactAndAllowWhileIdle(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1),
                        it)
                }
                beforeAndroid(Build.VERSION_CODES.N) {
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1),
                        it)
                }
            }
    }

    private fun schedulePeriodicAlarm() {
        Intent(this, ManifestDeclaredBroadcastReceiver::class.java)
            .apply { action = "com.daftacademy.androidlevelup.NOTIFY" }
            .let { PendingIntent.getBroadcast(this, 0, it, 0) }
            .let {
                alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(),
                    AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                    it)
            }
    }
}