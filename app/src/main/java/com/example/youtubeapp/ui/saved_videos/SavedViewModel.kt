package com.example.youtubeapp.ui.saved_videos

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapp.models.youtube.Item
import com.example.youtubeapp.repository.YoutubeLocalRepository

class SavedViewModel : ViewModel() {

    var localData = MutableLiveData<MutableList<Item>>()
    lateinit var localRepo: YoutubeLocalRepository

    fun initRepository( context: Context) {
        localRepo = YoutubeLocalRepository(context)
    }

    fun getDetailsFromDB() {
        localData.value = localRepo.getDetailsLocal()
    }
}