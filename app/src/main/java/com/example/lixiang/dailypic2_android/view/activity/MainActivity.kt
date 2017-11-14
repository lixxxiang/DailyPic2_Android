package com.example.lixiang.dailypic2_android.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.lixiang.dailypic2_android.R
import android.support.design.widget.BottomNavigationView
import com.example.lixiang.dailypic2_android.util.BottomNavigationViewHelper
import android.support.v4.view.ViewPager
import android.widget.AdapterView
import com.example.lixiang.dailypic2_android.util.ViewPagerAdapter
import butterknife.BindView
import butterknife.OnItemClick
import com.example.lixiang.dailypic2_android.view.fragment.HomeFragment
import com.example.lixiang.dailypic2_android.view.fragment.MeFragment
import com.example.lixiang.dailypic2_android.view.fragment.PicFragment
import com.example.lixiang.dailypic2_android.view.fragment.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.lixiang.dailypic2_android.util.GlideImageLoader
import com.youth.banner.Banner
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity() {
    /**
     * test Banner
     */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        BottomNavigationViewHelper.disableShiftMode(navigation)

        /**
         * banner
         */

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(HomeFragment())
        viewPagerAdapter.addFragment(PicFragment())
        viewPagerAdapter.addFragment(VideoFragment())
        viewPagerAdapter.addFragment(MeFragment())
        main_viewpager.setAdapter(viewPagerAdapter)


        navigation.setOnNavigationItemSelectedListener { item ->
//            var itemId = item.itemId
            var tab = 0
            when (item.itemId) {
                R.id.navigation_home -> tab = 0
                R.id.navigation_pic -> tab = 1
                R.id.navigation_video -> tab = 2
                R.id.navigation_me -> tab = 3
            }
            main_viewpager.setCurrentItem(tab)
            false
        }
        main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                navigation.menu.getItem(position).setChecked(true)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


    }
}