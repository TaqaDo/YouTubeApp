package com.example.youtubeapp.ui.playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeapp.R
import com.example.youtubeapp.adapters.PlayListAdapter
import kotlinx.android.synthetic.main.activity_splash.*

class PlayListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val adapter = PlayListAdapter(getLIst())
        playListRecycler.adapter = adapter
    }

    private fun getLIst(): List<PlayListInfo> {
        val list = ArrayList<PlayListInfo>()
        val video = PlayListInfo(R.drawable.ic_cat_background, "Privet KAK DELAAAAAAAAAAA", "1000000000000")
        for (i in 1..10) {
            list.apply {
                add(video)
            }
        }
        return list
    }
}