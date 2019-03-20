package pl.daftacademy.androidlevelup.view.fragment.transaction

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fragment_transaction.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.fragment.TestFragment

class FragmentTransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        "onCreate()".logd()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_transaction)
        btnAddFragment.setOnClickListener { addFragment() }
    }

    override fun onStart() {
        "onStart()".logd()
        super.onStart()
    }

    override fun onResume() {
        "onResume()".logd()
        super.onResume()
    }

    override fun onPause() {
        "onPause()".logd()
        super.onPause()
    }

    override fun onStop() {
        "onStop()".logd()
        super.onStop()
    }

    override fun onDestroy() {
        "onDestroy()".logd()
        super.onDestroy()
    }

    private fun addFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, TestFragment())
            .addToBackStack(null)
            .commitNow()
        btnAddFragment.visibility = View.GONE
    }

    private fun String.logd() = Log.d("Activity", this)
}