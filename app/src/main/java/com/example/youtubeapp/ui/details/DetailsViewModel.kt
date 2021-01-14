package com.example.youtubeapp.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapp.models.resource_courutines.Resource
import com.example.youtubeapp.models.youtube.PlaylistResponse
import com.example.youtubeapp.repository.YoutubeRepository

class DetailsViewModel : ViewModel() {
    var repo = YoutubeRepository()

    fun fetchDetailsListFromServer(videoId: String): LiveData<Resource<PlaylistResponse>> {
        return repo.fetchDetailsList(videoId)
    }

    fun fetchNextDetailsList(videoId: String, nextPageToken: String): LiveData<Resource<PlaylistResponse>> {
        return repo.fetchNextDetailsList(videoId,nextPageToken)
    }
}