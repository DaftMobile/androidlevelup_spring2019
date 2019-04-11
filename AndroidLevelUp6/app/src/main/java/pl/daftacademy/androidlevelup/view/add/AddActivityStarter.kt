package pl.daftacademy.androidlevelup.view.add

import android.content.Context
import android.content.Intent

class AddActivityStarter {

    fun getStarterIntent(context: Context) = Intent(context, AddActivity::class.java)
}