package cn.dev.knowall.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.dev.knowall.R
import cn.dev.knowall.container.AFragment
import cn.dev.knowall.container.BFragment
import cn.dev.knowall.container.CFragment
import cn.dev.knowall.controller.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(AFragment(), "A")
        adapter.addFragment(BFragment(), "B")
        adapter.addFragment(CFragment(), "C")
        mViewPager.adapter = adapter
        tabLayout.setupWithViewPager(mViewPager)
    }
}
