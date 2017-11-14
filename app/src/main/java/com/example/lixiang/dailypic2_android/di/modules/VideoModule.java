package com.example.lixiang.dailypic2_android.di.modules;


import com.example.lixiang.dailypic2_android.presenter.PicContract;
import com.example.lixiang.dailypic2_android.presenter.VideoContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lixiang on 2017/10/20.
 */

@Module
public class VideoModule {
    private final VideoContract.View mView;

    public VideoModule(VideoContract.View mView){
        this.mView = mView;
    }

    @Provides
    public VideoContract.View provideVideoView(){
        return mView;
    }
}
