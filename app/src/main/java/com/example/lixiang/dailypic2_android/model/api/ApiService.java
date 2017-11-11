package com.example.lixiang.dailypic2_android.model.api;


import com.example.lixiang.dailypic2_android.model.entity.homePage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lixiang on 2017/10/20.
 */

public interface ApiService {
    @POST("mobile/homePage")
    @FormUrlEncoded
    Call<homePage> homePage(@Field("pageSize") String targetSentence,
                                     @Field("pageNum") String targetSentence2);

}
