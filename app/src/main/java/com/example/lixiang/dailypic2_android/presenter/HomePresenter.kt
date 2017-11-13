@file:Suppress("UNREACHABLE_CODE")

package com.example.lixiang.dailypic2_android.presenter


import com.example.lixiang.dailypic2_android.model.api.ApiService
import com.example.lixiang.dailypic2_android.model.entity.DailyPicDetail
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
    internal val content: MutableList<homePage.DataBean.MixedContentListBean> = mutableListOf()
    internal var detailContent: DailyPicDetail.DataBean? = null

    override fun getDailyPicDetail(id: String) {
        retrofit = NetUtils.getRetrofit()
        apiService = retrofit!!.create(ApiService::class.java)
        val call = apiService!!.DailyPicDetail(id)
        call.enqueue(object : retrofit2.Callback<DailyPicDetail> {
            override fun onFailure(call: Call<DailyPicDetail>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<DailyPicDetail>?, response: Response<DailyPicDetail>?) {
                detailContent = response!!.body().data
                view.toPicDetailPage(detailContent)
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
                (0 until response!!.body().data.mixedContentList.size).mapTo(content) { response.body().data.mixedContentList.get(it) }
                view.loadData(content)
            }
        })
    }
}
