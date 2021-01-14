package com.example.youtubeapp.repository

import androidx.lifecycle.liveData
import com.example.youtubeapp.data.network.retrofit.RetrofitClient
import com.example.youtubeapp.models.resource_courutines.Resource
import com.example.youtubeapp.utills.Constants.Companion.API
import kotlinx.coroutines.Dispatchers

class YoutubeRepository {

    val channelId = "UC_pwIXKXNm5KGhdEVzmY60A"
    val key  = API
    val part = "snippet,contentDetails"
    val maxResults = 10
    private val api = RetrofitClient().retrofitInstance()

    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.fetchPlaylists(part,channelId,key,maxResults)))
        } catch (ex: Exception) {
            emit(Resource.error(data = null, message = ex.message.toString()))
        }
    }

    fun fetchNextPlaylist(nextPageToken: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getNextPlaylists(part, channelId, key, maxResults, nextPageToken)))
        } catch (ex: Exception) {
            emit(Resource.error(data = null, message = ex.message.toString()))
        }
    }

    fun fetchDetailsList(videoListId: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getDetailsList(part, videoListId, key, maxResults)))
        } catch (ex: Exception) {
            emit(Resource.error(data = null, message = ex.message.toString()))
        }
    }

    fun fetchNextDetailsList(nextPageToken: String, videoListId: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getNextDetailsList(part,videoListId,key,maxResults,nextPageToken)))
        } catch (ex: Exception) {
            emit(Resource.error(data = null, message = ex.message.toString()))
        }
    }

}