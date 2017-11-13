package com.example.lixiang.dailypic2_android.view.activity

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Button
import com.androidkun.xtablayout.XTabLayout
import com.example.lixiang.dailypic2_android.R
import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail
import com.example.lixiang.dailypic2_android.util.PicDetailAdapter
import com.example.lixiang.dailypic2_android.view.fragment.PicDetailFragment_1
import com.example.lixiang.dailypic2_android.view.fragment.PicDetailFragment_2
import kotlinx.android.synthetic.main.activity_pic_detail.*
import kotlinx.android.synthetic.main.pic_detail_1.*
import kotlinx.android.synthetic.main.pic_detail_2.*
import java.util.*

class PicDetailActivity : AppCompatActivity() {

    var toFragment = DailyPicDetail.DataBean()
    val titleList = object : ArrayList<String>() {
        init {
            add("每日一图")
            add("发生位置")
        }
    }

    val fragmentList = object : ArrayList<Fragment>() {
        init {
            add(PicDetailFragment_1())
            add(PicDetailFragment_2())
        }
    }

    var adapter: PicDetailAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pic_detail)
        adapter = PicDetailAdapter(supportFragmentManager, titleList, fragmentList)
        viewpager.setAdapter(adapter)
        xTablayout.setupWithViewPager(viewpager)
        xTablayout.setTabsFromPagerAdapter(adapter)
        xTablayout!!.setOnTabSelectedListener(object : XTabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: XTabLayout.Tab) {
                println("tab" + tab.position)
                if (tab.position == 0) {
                    pic_detail_1.visibility = View.VISIBLE
                    pic_detail_2.visibility = View.INVISIBLE
                } else {
                    pic_detail_1.visibility = View.INVISIBLE
                    pic_detail_2.visibility = View.VISIBLE
                }
            }

            override fun onTabUnselected(tab: XTabLayout.Tab) {
            }

            override fun onTabReselected(tab: XTabLayout.Tab) {
            }
        })
        toFragment = getIntent().getSerializableExtra("detailContent") as DailyPicDetail.DataBean
        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                finish()
            }
        })

        if (toFragment.richText1 != null)
            description_1.setText(toFragment.richText1)
        if (toFragment.richText2 != null)
            description_2.setText(toFragment.richText2)
        if (toFragment.richText3 != null)
            description_3.setText(toFragment.richText3)
        if (toFragment.image1FilePath != null)
            picture_1.setImageURI(Uri.parse(toFragment.image1FilePath))
        if (toFragment.image2FilePath != null)
            picture_2.setImageURI(Uri.parse(toFragment.image2FilePath))
        if (toFragment.image3FilePath != null)
            picture_3.setImageURI(Uri.parse(toFragment.image3FilePath))
    }

    fun getData(): DailyPicDetail.DataBean? {
        return toFragment
    }
}
