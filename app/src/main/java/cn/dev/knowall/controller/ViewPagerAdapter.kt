package cn.dev.knowall.controller

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private var fragments = ArrayList<Fragment>()
    private var titles = ArrayList<String>()
    override fun getItem(position: Int): Fragment = fragments[position]
    override fun getCount(): Int = titles.size
    override fun getPageTitle(position: Int): CharSequence = titles[position]
    fun addFragment(fragment: Fragment, title: String) {  //将碎片加入集合
        fragments.add(fragment)
        titles.add(title)
    }
}