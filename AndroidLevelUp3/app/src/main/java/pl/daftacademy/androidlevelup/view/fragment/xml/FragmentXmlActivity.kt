package pl.daftacademy.androidlevelup.view.fragment.xml

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import pl.daftacademy.androidlevelup.R

class FragmentXmlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        "onCreate()".logd()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_xml)
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

    private fun String.logd() = Log.d("Activity", this)
}