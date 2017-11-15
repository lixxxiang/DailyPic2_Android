package com.example.lixiang.dailypic2_android.presenter

import com.example.lixiang.dailypic2_android.model.entity.DailyPic

/**
 * Created by 刘晓 on 2017/11/14.
 */

interface PicContract {
    interface Presenter {
        fun loadPicData(pageSize:String, pageNum:String)
    }

    interface View{
        fun loadPicData(content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean>)
    }
}
