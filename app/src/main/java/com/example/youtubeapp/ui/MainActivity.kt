package com.example.youtubeapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.youtubeapp.R
import com.example.youtubeapp.core.BaseActivity
import com.example.youtubeapp.core.MainViewModel
import com.example.youtubeapp.ui.playlist.PlayListActivity

class MainActivity : BaseActivity(R.layout.activity_main) {
    private lateinit var vm: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }

}