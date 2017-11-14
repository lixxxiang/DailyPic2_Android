package com.example.lixiang.dailypic2_android.di.components;

import com.example.lixiang.dailypic2_android.di.modules.PicModule;
import com.example.lixiang.dailypic2_android.view.fragment.PicFragment;

import dagger.Component;

/**
 * Created by 刘晓 on 2017/11/14.
 */
@Component(modules = PicModule.class)
public interface PicComponent {
    void inject(PicFragment fragment);
}
