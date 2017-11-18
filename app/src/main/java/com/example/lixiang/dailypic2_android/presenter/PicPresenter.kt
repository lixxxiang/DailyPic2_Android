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
    internal var picContent: DailyPic.DataBean? = null
    internal val sumContent: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean> = mutableListOf()
    internal var picDetailContent: DailyPicDetail.DataBean? = null
    override fun loadPicData(pageSize: String, pageNum: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.DailyPic(pageSize, pageNum)
        call.enqueue(object : retrofit2.Callback<DailyPic> {
            override fun onFailure(call: Call<DailyPic>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<DailyPic>?, response: Response<DailyPic>?) {
                val content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean> = mutableListOf()
                (0 until response!!.body().data.sjDailyPicDtoList.size).mapTo(content) { response.body().data.sjDailyPicDtoList.get(it) }
                if(sumContent.size != 0)
                    sumContent.clear()
                sumContent.addAll(content)
                view.loadPicData(sumContent, response!!.body().data.pages)
            }
        })
    }

    override fun loadMorePicData(pageSize: String, pageNum: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.DailyPic(pageSize, pageNum)
        call.enqueue(object : retrofit2.Callback<DailyPic> {
            override fun onFailure(call: Call<DailyPic>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<DailyPic>?, response: Response<DailyPic>?) {
                val content: MutableList<DailyPic.DataBean.SjDailyPicDtoListBean> = mutableListOf()
                (0 until response!!.body().data.sjDailyPicDtoList.size).mapTo(content) { response.body().data.sjDailyPicDtoList.get(it) }
                sumContent.addAll(content)
                view.loadMorePicData(sumContent)
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
