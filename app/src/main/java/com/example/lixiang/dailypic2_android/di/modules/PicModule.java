package com.example.lixiang.dailypic2_android.di.modules;


import com.example.lixiang.dailypic2_android.presenter.PicContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lixiang on 2017/10/20.
 */

@Module
public class PicModule {
    private final PicContract.View mView;

    public PicModule(PicContract.View mView){
        this.mView = mView;
    }

    @Provides
    public PicContract.View providePicView(){
        return mView;
    }
}
