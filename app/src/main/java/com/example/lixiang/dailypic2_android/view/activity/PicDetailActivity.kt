package com.example.lixiang.dailypic2_android.view.activity

import android.app.Activity
import android.content.Intent
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
import org.apache.cordova.*
import org.apache.cordova.engine.SystemWebView
import org.apache.cordova.engine.SystemWebViewEngine
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class PicDetailActivity : AppCompatActivity(), CordovaInterface {
    var cordovaWebView: CordovaWebView? = null
    private val threadPool = Executors.newCachedThreadPool()
    protected var activityResultRequestCode: Int = 0
    protected var prefs = CordovaPreferences()
    protected var pluginEntries: ArrayList<PluginEntry>? = null
    protected var activityResultCallback1: CordovaPlugin? = null
    lateinit var systemWebView: SystemWebView

    override fun requestPermissions(p0: CordovaPlugin?, p1: Int, p2: Array<out String>?) {

    }

    override fun startActivityForResult(p0: CordovaPlugin?, p1: Intent?, p2: Int) {
        setActivityResultCallback(p0)
        try {
            startActivityForResult(p1, p2)
        } catch (e: RuntimeException) {
            activityResultCallback1 = null
            throw e
        }
    }

    override fun setActivityResultCallback(p0: CordovaPlugin?) {
        if (activityResultCallback1 != null) {
            activityResultCallback1!!.onActivityResult(activityResultRequestCode, Activity.RESULT_CANCELED, null);
        }
        activityResultCallback1 = p0
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun onMessage(p0: String?, p1: Any?): Any? {
        if ("exit".equals(p0)) {
            super.finish()
        }
        return null
    }

    override fun getThreadPool(): ExecutorService {
        return threadPool

    }

    override fun hasPermission(p0: String?): Boolean {
        return false
    }

    override fun requestPermission(p0: CordovaPlugin?, p1: Int, p2: String?) {
    }

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
        pic_detail_2.visibility = View.INVISIBLE
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
                    webview.loadUrl("javascript:fly(\"" + toFragment.latitude + "\",\""+toFragment.longitude+ "\")")
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
        systemWebView = findViewById(R.id.webview)
        val parser = ConfigXmlParser()
        parser.parse(this)
        cordovaWebView = CordovaWebViewImpl(SystemWebViewEngine(systemWebView))
        cordovaWebView!!.init(this, parser.pluginEntries, parser.preferences)
        webview.loadUrl("file:///android_asset/www/index.html")

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



//        Thread(Runnable {
//            try {
//                Thread.sleep(4000)
//                runOnUiThread {
//                    //不能在子线程中执行webview的方法
//                    webview.loadUrl("javascript:fly(\"25\",\"34\")")
//                }
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//        }).start()
    }

    fun getData(): DailyPicDetail.DataBean? {
        return toFragment
    }
}
