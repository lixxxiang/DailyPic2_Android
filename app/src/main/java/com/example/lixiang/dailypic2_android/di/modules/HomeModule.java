package com.example.lixiang.dailypic2_android.di.modules;


import com.example.lixiang.dailypic2_android.presenter.HomeContract;
import com.example.lixiang.dailypic2_android.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lixiang on 2017/10/20.
 */

@Module
public class HomeModule {
    private final HomeContract.View mView;

    public HomeModule(HomeContract.View mView){
        this.mView = mView;
    }

    @Provides
    public HomeContract.View provideHomeView(){
        return mView;
    }
}
