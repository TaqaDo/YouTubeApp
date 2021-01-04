package com.example.youtubeapp.ui.playlist

import android.graphics.Insets.add
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.youtubeapp.R
import com.example.youtubeapp.adapters.PlayListAdapter
import com.example.youtubeapp.core.BaseActivity
import com.example.youtubeapp.models.youtube.PlaylistResponse
import kotlinx.android.synthetic.main.activity_playlist.*

class PlayListActivity : BaseActivity(R.layout.activity_playlist) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = PlayListAdapter(getLIst())
        playListRecycler.adapter = adapter
    }



    private fun getLIst(): List<PlaylistResponse> {
        val list = ArrayList<PlaylistResponse>()
        val video = PlaylistResponse()
        for (i in 1..10) {
            list.apply {
                add(video)
            }
        }
        return list
    }
}