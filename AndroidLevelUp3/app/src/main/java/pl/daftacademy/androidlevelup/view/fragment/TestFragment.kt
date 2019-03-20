package pl.daftacademy.androidlevelup.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.daftacademy.androidlevelup.R

class TestFragment: Fragment() {


    override fun onAttach(context: Context?) {
        "onAttach()".logd()
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        "onCreate()".logd()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        "onCreateView()".logd()
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        "onActivityCreated()".logd()
        super.onActivityCreated(savedInstanceState)
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

    override fun onDestroyView() {
        "onDestroyView()".logd()
        super.onDestroyView()
    }

    override fun onDestroy() {
        "onDestroy()".logd()
        super.onDestroy()
    }

    override fun onDetach() {
        "onDetach()".logd()
        super.onDetach()
    }

    private fun String.logd() = Log.d("Fragment", this)
}