package com.example.lixiang.dailypic2_android.di.components;

import com.example.lixiang.dailypic2_android.di.modules.VideoModule;
import com.example.lixiang.dailypic2_android.view.fragment.VideoFragment;

import dagger.Component;

/**
 * Created by 刘晓 on 2017/11/14.
 */
@Component(modules = VideoModule.class)
public interface VideoComponent {
    void inject(VideoFragment fragment);
}
