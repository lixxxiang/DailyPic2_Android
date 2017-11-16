package com.example.lixiang.dailypic2_android.presenter

import com.example.lixiang.dailypic2_android.model.entity.PlanetEarth
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarthDetail

/**
 * Created by 刘晓 on 2017/11/14.
 */

interface VideoContract {
    interface Presenter{
        fun loadVideoData(pageSize : String, pageNum : String)
        fun getPlanetEarthDetail(id : String)
    }

    interface View{
        fun loadVideoData(content: MutableList<PlanetEarth.DataBean.SjMobilePlanetEarthDtoListBean>)
        fun toVideoDetailPage(videoDetailContent: PlanetEarthDetail.DataBean?)
    }
}
