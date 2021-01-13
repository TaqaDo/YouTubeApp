package com.example.youtubeapp.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtubeapp.data.network.retrofit.RetrofitClient
import com.example.youtubeapp.models.youtube.PlaylistResponse
import com.example.youtubeapp.utills.Constants
import com.example.youtubeapp.utills.Constants.Companion.API
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YoutubeRepository {

    val channelId = "UCApdP81v1rMFGiFUq-A7vBQ"
    val key  = API
    val part = "snippet,contentDetails"
    private val api = RetrofitClient().retrofitInstance()

    fun fetchPlaylists() = liveData(Dispatcher.IO) {

    }

    fun fetchPlaylistFromServer(): MutableLiveData<PlaylistResponse>{
        var data = MutableLiveData<PlaylistResponse>()
        api.fetchPlaylists(part,channelId,key).enqueue(object :
            retrofit2.Callback<PlaylistResponse> {
            override fun onResponse(
                call: Call<PlaylistResponse>,
                response: Response<PlaylistResponse>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<PlaylistResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: $t " )
            }

        })
        return data

    }
}