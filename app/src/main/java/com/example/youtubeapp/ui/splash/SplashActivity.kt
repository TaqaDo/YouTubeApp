package com.example.youtubeapp.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeapp.R
import com.example.youtubeapp.models.Video
import com.example.youtubeapp.adapters.VideoAdapter
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val adapter = VideoAdapter(getLIst())
        splashRecycler.adapter = adapter
    }

    private fun getLIst(): List<Video> {
        val list = ArrayList<Video>()
        val video = Video(R.drawable.ic_cat_background, "Privet KAK DELAAAAAAAAAAA", "1000000000000")
        for (i in 1..10) {
            list.apply {
                add(video)
            }
        }
        return list
    }
}