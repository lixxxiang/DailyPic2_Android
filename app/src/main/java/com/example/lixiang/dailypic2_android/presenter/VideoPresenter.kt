package com.example.lixiang.dailypic2_android.presenter

import com.example.lixiang.dailypic2_android.model.api.ApiService
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarth
import com.example.lixiang.dailypic2_android.util.NetUtils
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by 刘晓 on 2017/11/14.
 */

class VideoPresenter @Inject
constructor(private val view: VideoContract.View) : VideoContract.Presenter {
    internal var retrofit: Retrofit? = null
    internal var apiService: ApiService? = null
    internal var content: MutableList<PlanetEarth.DataBean.SjMobilePlanetEarthDtoListBean> = mutableListOf()
    internal var videoContent: PlanetEarth.DataBean? = null
    override fun loadVideoData(pageSize: String, pageNum: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.PlanetEarth(pageSize, pageNum)
        call.enqueue(object : retrofit2.Callback<PlanetEarth> {
            override fun onFailure(call: Call<PlanetEarth>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<PlanetEarth>?, response: Response<PlanetEarth>?) {
                (0 until response!!.body().data.sjMobilePlanetEarthDtoList.size).mapTo(content) { response.body().data.sjMobilePlanetEarthDtoList.get(it) }
                view.loadVideoData(content)
            }
        })
    }

}
