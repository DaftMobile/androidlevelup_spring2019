package pl.daftacademy.androidlevelup.feature.work

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kotlinx.android.synthetic.main.activity_work.*
import pl.daftacademy.androidlevelup.R
import java.util.concurrent.TimeUnit

class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        btnScheduleSingleWork.setOnClickListener { scheduleSingleWork() }
        btnSchedulePeriodicWork.setOnClickListener { schedulePeriodicWork() }
    }

    private fun scheduleSingleWork() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .build()
        val request = OneTimeWorkRequest.Builder(ShowToastWorker::class.java)
            .setConstraints(constraints)
            .build()
        WorkManager
            .getInstance()
            .enqueueUniqueWork(ShowToastWorker::javaClass.name, ExistingWorkPolicy.APPEND, request)
    }

    private fun schedulePeriodicWork() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .build()
        val request = PeriodicWorkRequest.Builder(ShowToastWorker::class.java, 20L, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()
        WorkManager
            .getInstance()
            .enqueueUniquePeriodicWork(ShowToastWorker::javaClass.name, ExistingPeriodicWorkPolicy.REPLACE, request)
    }
}