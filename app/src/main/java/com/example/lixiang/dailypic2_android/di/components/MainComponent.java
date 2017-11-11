package com.example.lixiang.dailypic2_android.di.components;


import com.example.lixiang.dailypic2_android.di.modules.MainModule;
import com.example.lixiang.dailypic2_android.view.activity.MainActivity;

import dagger.Component;

/**
 * Created by lixiang on 2017/10/20.
 */
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}