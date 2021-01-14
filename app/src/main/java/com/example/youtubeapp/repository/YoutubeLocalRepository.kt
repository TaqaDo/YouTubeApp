package com.example.youtubeapp.repository

import android.content.Context
import com.example.youtubeapp.data.local.room.YoutubeDatabase
import com.example.youtubeapp.models.youtube.Item

class YoutubeLocalRepository(context: Context) {
    private val youtubeDao = YoutubeDatabase.getDatabase(context).youTubedao()

    fun getDetailsLocal(): MutableList<Item> {
        return youtubeDao.getDetailslist()
    }

    fun addDetailsLocal(list: MutableList<Item>){
        return youtubeDao.addDetailsList(list)
    }

    fun deleteAll() {
        youtubeDao.deleteAll()
    }
}