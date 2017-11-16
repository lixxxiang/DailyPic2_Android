package com.example.lixiang.dailypic2_android.presenter

import com.example.lixiang.dailypic2_android.model.entity.DailyPic
import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail

/**
 * Created by 刘晓 on 2017/11/14.
 */

interface PicContract {
    interface Presenter {
        fun loadPicData(pageSize:String, pageNum:String)
        fun getDailyPicDetail(id : String)
    }

    interface View{
        fun loadPicData(content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean>)
        fun toPicDetailPage(picDetailContent: DailyPicDetail.DataBean?)
    }
}
