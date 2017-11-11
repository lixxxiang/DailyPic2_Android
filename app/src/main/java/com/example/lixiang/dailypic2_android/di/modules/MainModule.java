package com.example.lixiang.dailypic2_android.di.modules;


import com.example.lixiang.dailypic2_android.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lixiang on 2017/10/20.
 */

@Module
public class MainModule {
    private final MainContract.View mView;

    public MainModule(MainContract.View mView){
        this.mView = mView;
    }

    @Provides
    public MainContract.View provideMainView(){
        return mView;
    }
}
