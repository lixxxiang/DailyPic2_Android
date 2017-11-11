package com.example.lixiang.dailypic2_android.presenter

import com.example.lixiang.dailypic2_android.model.entity.homePage

/**
 * Created by lixiang on 2017/10/20.
 */

interface HomeContract {
    interface Presenter {
        fun getHomePageData(size : String, num : String)
    }

    interface View{
        fun loadData(content: MutableList<homePage.DataBean.MixedContentListBean>)
    }
}
