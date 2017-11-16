package com.example.lixiang.dailypic2_android.presenter

import com.example.lixiang.dailypic2_android.model.api.ApiService
import com.example.lixiang.dailypic2_android.model.entity.DailyPic
import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail
import com.example.lixiang.dailypic2_android.util.NetUtils
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by 刘晓 on 2017/11/14.
 */


class PicPresenter @Inject
constructor(private val view: PicContract.View) : PicContract.Presenter {


    internal var retrofit: Retrofit? = null
    internal var apiService: ApiService? = null
    internal var content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean> = mutableListOf()
    internal var picContent: DailyPic.DataBean? = null
    internal var picDetailContent: DailyPicDetail.DataBean? = null
    override fun loadPicData(pageSize: String, pageNum: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.DailyPic(pageSize, pageNum)
        call.enqueue(object : retrofit2.Callback<DailyPic> {
            override fun onFailure(call: Call<DailyPic>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<DailyPic>?, response: Response<DailyPic>?) {
                (0 until response!!.body().data.sjDailyPicDtoList.size).mapTo(content) { response.body().data.sjDailyPicDtoList.get(it) }
                view.loadPicData(content)
            }
        })
    }

    override fun getDailyPicDetail(id: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.DailyPicDetail(id)
        call.enqueue(object : retrofit2.Callback<DailyPicDetail> {
            override fun onFailure(call: Call<DailyPicDetail>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<DailyPicDetail>?, response: Response<DailyPicDetail>?) {
                picDetailContent = response!!.body().data
                view.toPicDetailPage(picDetailContent)
            }
        })
    }
}
