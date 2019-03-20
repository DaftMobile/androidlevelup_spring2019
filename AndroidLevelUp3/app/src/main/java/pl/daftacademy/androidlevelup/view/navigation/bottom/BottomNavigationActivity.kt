package pl.daftacademy.androidlevelup.view.navigation.bottom

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.navigation.ContentFragment

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        nav.setOnNavigationItemSelectedListener { changePage(item = it) }
        if (savedInstanceState == null) showPage("Home")
    }

    private fun changePage(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home -> showPage("Home")
            R.id.action_camera -> showPage("Camera")
            R.id.action_fire -> showPage("Fire")
            R.id.action_settings -> showPage("Settings")
            else -> return false
        }
        return true
    }

    private fun showPage(name: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ContentFragment.create(name))
            .commit()
    }
}