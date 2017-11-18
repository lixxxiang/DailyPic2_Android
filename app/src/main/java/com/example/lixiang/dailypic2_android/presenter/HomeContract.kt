package com.example.lixiang.dailypic2_android.presenter

import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarthDetail
import com.example.lixiang.dailypic2_android.model.entity.homePage

/**
 * Created by lixiang on 2017/10/20.
 */

interface HomeContract {
    interface Presenter {
        fun getHomePageData(size : String, num : String)
        fun getDailyPicDetail(id : String)
        fun getVideoPicDetail(id : String)
        fun loadMore(size : String, num : String)
    }

    interface View{
        fun loadData(content: MutableList<homePage.DataBean.MixedContentListBean>, count: Int )
        fun toPicDetailPage(picDetailContent: DailyPicDetail.DataBean?)
        fun toVideoDetailPage(videoDetailContent: PlanetEarthDetail.DataBean?)
        fun loadMoreData(content: MutableList<homePage.DataBean.MixedContentListBean>)
    }
}
