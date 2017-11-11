package com.example.lixiang.dailypic2_android

import android.app.Application

import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by lixiang on 2017/11/10.
 */

class DPApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}
