package pl.daftacademy.androidlevelup.feature.work

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import pl.daftacademy.androidlevelup.util.ext.logd

class ShowToastWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    private val TAG = "ShowToastWorker"

    override fun doWork(): Result {
        "doWork()".logd(TAG)
        Thread.currentThread().logd(TAG)
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(applicationContext, "doWork()", Toast.LENGTH_LONG).show()
        }
        return Result.success()
    }
}