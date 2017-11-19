package com.example.lixiang.dailypic2_android.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

import com.example.lixiang.dailypic2_android.view.fragment.intro.IntroFragment_1;
import com.example.lixiang.dailypic2_android.view.fragment.intro.IntroFragment_2;
import com.example.lixiang.dailypic2_android.view.fragment.intro.IntroFragment_3;
import com.github.paolorotolo.appintro.AppIntro;

public class IntroActivity extends AppIntro {


    IntroFragment_1 introFragment_1 = new IntroFragment_1();
    IntroFragment_2 introFragment_2 = new IntroFragment_2();
    IntroFragment_3 introFragment_3 = new IntroFragment_3();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addSlide(introFragment_1);
        addSlide(introFragment_2);
        addSlide(introFragment_3);
        setBarColor(Color.parseColor("#00000000"));
        setSeparatorColor(Color.parseColor("#00000000"));
        setSkipText("跳过");
        setDoneText("完成");
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
        finish();
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        finish();
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
