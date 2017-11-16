@file:Suppress("UNREACHABLE_CODE")

package com.example.lixiang.dailypic2_android.presenter


import com.example.lixiang.dailypic2_android.model.api.ApiService
import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarth
import com.example.lixiang.dailypic2_android.model.entity.PlanetEarthDetail
import com.example.lixiang.dailypic2_android.model.entity.homePage
import com.example.lixiang.dailypic2_android.util.NetUtils
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
* Created by lixiang on 2017/10/20.
*/

class HomePresenter @Inject
constructor(private val view: HomeContract.View) : HomeContract.Presenter {



    internal var retrofit: Retrofit? = null
    internal var apiService: ApiService? = null

    internal var picDetailContent: DailyPicDetail.DataBean? = null
    internal var videoDetailContent: PlanetEarthDetail.DataBean? = null

    override fun getVideoPicDetail(id: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.PlanetEarthDetail(id)
        call.enqueue(object : retrofit2.Callback<PlanetEarthDetail> {
            override fun onFailure(call: Call<PlanetEarthDetail>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<PlanetEarthDetail>?, response: Response<PlanetEarthDetail>?) {
                videoDetailContent = response!!.body().data
                view.toVideoDetailPage(videoDetailContent)
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

    override fun getHomePageData(size: String, num: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.homePage(size, num)
        call.enqueue(object : retrofit2.Callback<homePage> {
            override fun onFailure(call: Call<homePage>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<homePage>?, response: Response<homePage>?) {
//                if(content != null){
//                    var content: MutableList<homePage.DataBean.MixedContentListBean> = mutableListOf()
//                }
                var content: MutableList<homePage.DataBean.MixedContentListBean> = mutableListOf()
                (0 until response!!.body().data.mixedContentList.size).mapTo(content) { response.body().data.mixedContentList.get(it) }
                println("==========" + content.get(0).contentName)
                view.loadData(content)
            }
        })
    }
}
