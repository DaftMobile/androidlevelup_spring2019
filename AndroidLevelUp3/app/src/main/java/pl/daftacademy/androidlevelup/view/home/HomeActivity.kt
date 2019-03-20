package pl.daftacademy.androidlevelup.view.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.fragment.transaction.FragmentTransactionActivity
import pl.daftacademy.androidlevelup.view.fragment.xml.FragmentXmlActivity
import pl.daftacademy.androidlevelup.view.navigation.bottom.BottomNavigationActivity
import pl.daftacademy.androidlevelup.view.navigation.drawer.NavigationDrawerActivity
import pl.daftacademy.androidlevelup.view.navigation.tabs.TabsActivity
import kotlin.reflect.KClass

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnFragmentTransaction.onClickStartActivity(FragmentTransactionActivity::class)
        btnFragmentXml.onClickStartActivity(FragmentXmlActivity::class)
        btnNavigationDrawer.onClickStartActivity(NavigationDrawerActivity::class)
        btnBottomNavigation.onClickStartActivity(BottomNavigationActivity::class)
        btnTabs.onClickStartActivity(TabsActivity::class)
    }

    private fun <T : Activity> View.onClickStartActivity(activityClass: KClass<T>) =
        setOnClickListener { startActivity(Intent(this@HomeActivity, activityClass.java)) }
}