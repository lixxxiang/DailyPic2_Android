package com.example.lixiang.dailypic2_android.di.components;

import com.example.lixiang.dailypic2_android.di.modules.HomeModule;
import com.example.lixiang.dailypic2_android.view.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by lixiang on 2017/11/10.
 */

@Component(modules = HomeModule.class)
public interface HomeComponent {
    void inject(HomeFragment fragment);
}
