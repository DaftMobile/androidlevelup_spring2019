package pl.daftacademy.androidlevelup.view.home

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_home.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.prefs.SharedUserPrefs
import pl.daftacademy.androidlevelup.prefs.UserPrefs
import pl.daftacademy.androidlevelup.view.add.AddActivity
import pl.daftacademy.androidlevelup.view.movies.MoviesFragment

class HomeActivity : AppCompatActivity() {

    private val userPrefs: UserPrefs by lazy { SharedUserPrefs(this, R.id.action_all) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        nav.setNavigationItemSelectedListener { changePage(item = it) }
        addMovieButton.setOnClickListener { startActivity(Intent(this, AddActivity::class.java)) }
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        if (savedInstanceState == null) changePage(nav.menu.findItem(userPrefs.startingPage))
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
            R.id.action_all -> showPage(null)
            R.id.action_action -> showPage("Action")
            R.id.action_comedy -> showPage("Comedy")
            R.id.action_crime -> showPage("Crime")
            R.id.action_horror -> showPage("Horror")
            R.id.action_romance -> showPage("Romance")
            else -> return false
        }
        nav.menu.children.find { it.isChecked }?.isChecked = false
        item.isChecked = true
        userPrefs.startingPage = item.itemId
        drawer.closeDrawers()
        return true
    }

    private fun showPage(genre: String?) {
        supportActionBar?.title = genre ?: "All Movies"
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, MoviesFragment.create(genre))
            .commit()
    }
}
