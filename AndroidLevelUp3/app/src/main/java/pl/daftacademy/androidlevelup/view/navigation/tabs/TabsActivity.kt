package pl.daftacademy.androidlevelup.view.navigation.tabs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tabs.*
import pl.daftacademy.androidlevelup.R

class TabsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)
        pager.adapter = TabsPagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(pager)
    }
}