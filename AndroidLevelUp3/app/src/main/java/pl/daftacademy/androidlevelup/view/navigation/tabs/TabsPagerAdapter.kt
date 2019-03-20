package pl.daftacademy.androidlevelup.view.navigation.tabs

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pl.daftacademy.androidlevelup.view.navigation.ContentFragment

class TabsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val names = listOf("Page 1", "Page 2")
    private val fragments = names.map { ContentFragment.create(it) }

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

    override fun getPageTitle(position: Int) = names[position]
}