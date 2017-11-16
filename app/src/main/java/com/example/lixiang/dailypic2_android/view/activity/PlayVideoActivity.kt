package com.example.lixiang.dailypic2_android.view.activity

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lixiang.dailypic2_android.R
import android.widget.RelativeLayout
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_play_video.*
import android.view.WindowManager


class PlayVideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_play_video)

        val uri = Uri.parse(intent.getStringExtra("url"))
        videoView.setMediaController(MediaController(this))
        videoView.setVideoURI(uri)
        val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.FILL_PARENT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT)
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
        videoView.layoutParams = layoutParams
        videoView.start()
    }
}
