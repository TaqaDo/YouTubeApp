package com.example.youtubeapp.ui.details

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapp.models.resource_courutines.Resource
import com.example.youtubeapp.models.youtube.Item
import com.example.youtubeapp.models.youtube.PlaylistResponse
import com.example.youtubeapp.repository.YoutubeLocalRepository
import com.example.youtubeapp.repository.YoutubeNetworkRepository

class DetailsViewModel : ViewModel() {
    var repo = YoutubeNetworkRepository()
    var localData = MutableLiveData<MutableList<Item>>()
    lateinit var localRepo: YoutubeLocalRepository

    fun initRepository( context: Context) {
        localRepo = YoutubeLocalRepository(context)
    }

    fun addDetailsToDB(list: MutableList<Item>) {
        localRepo.addDetailsLocal(list)
    }

    fun fetchDetailsListFromServer(videoId: String): LiveData<Resource<PlaylistResponse>> {
        return repo.fetchDetailsList(videoId)
    }

    fun fetchNextDetailsList(videoId: String, nextPageToken: String): LiveData<Resource<PlaylistResponse>> {
        return repo.fetchNextDetailsList(videoId,nextPageToken)
    }

    fun deleteAll() {
        localRepo.deleteAll()
    }
}