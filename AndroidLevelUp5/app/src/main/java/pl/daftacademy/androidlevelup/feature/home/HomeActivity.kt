package pl.daftacademy.androidlevelup.feature.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.feature.alarm.AlarmActivity
import pl.daftacademy.androidlevelup.feature.broadcast.BroadcastActivity
import pl.daftacademy.androidlevelup.feature.service.ServiceActivity
import pl.daftacademy.androidlevelup.feature.work.WorkActivity
import kotlin.reflect.KClass

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnService.onClickStartActivity(ServiceActivity::class)
        btnBroadcast.onClickStartActivity(BroadcastActivity::class)
        btnWork.onClickStartActivity(WorkActivity::class)
        btnAlarm.onClickStartActivity(AlarmActivity::class)
    }

    private fun <T : Activity> View.onClickStartActivity(activityClass: KClass<T>) =
        setOnClickListener { startActivity(Intent(this@HomeActivity, activityClass.java)) }
}