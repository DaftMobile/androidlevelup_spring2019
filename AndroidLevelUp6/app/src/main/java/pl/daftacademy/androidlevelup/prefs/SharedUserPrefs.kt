package pl.daftacademy.androidlevelup.prefs

import android.app.Activity
import android.content.Context

class SharedUserPrefs(activity: Activity, private val defaultStartingPage: Int) : UserPrefs {
    private val sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)

    override var startingPage: Int
        get() = sharedPreferences.getInt(STARTING_PAGE_KEY, defaultStartingPage)
        set(value) = sharedPreferences.edit().putInt(STARTING_PAGE_KEY, value).apply()

    companion object {
        private const val STARTING_PAGE_KEY = "starting_page"
    }
}
