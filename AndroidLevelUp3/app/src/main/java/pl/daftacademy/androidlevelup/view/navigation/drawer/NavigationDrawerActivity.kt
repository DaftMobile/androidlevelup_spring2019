package pl.daftacademy.androidlevelup.view.navigation.drawer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.navigation.ContentFragment

class NavigationDrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)
        nav.setNavigationItemSelectedListener { changePage(item = it) }
        if (savedInstanceState == null) showPage("Home", addToBackStack = false)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun changePage(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home -> showPage("Home")
            R.id.action_users -> showPage("Users")
            R.id.action_camera -> showPage("Camera")
            R.id.action_fire -> showPage("Fire")
            R.id.action_settings -> showPage("Settings")
            else -> return false
        }
        nav.menu.children.find { it.isChecked }?.isChecked = false
        item.isChecked = true
        drawer.closeDrawers()
        return true
    }

    private fun showPage(name: String, addToBackStack: Boolean = false) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ContentFragment.create(name))
            .apply { if(addToBackStack) addToBackStack(null) }
            .commit()
    }
}