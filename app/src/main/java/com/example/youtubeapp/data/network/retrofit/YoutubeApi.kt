package com.example.youtubeapp.data.network.retrofit

import com.example.youtubeapp.models.youtube.PlaylistResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {

    @GET("youtube/v3/playlists")
    fun fetchPlaylists(
        @Query("part") part:String,
        @Query("channelId") channelId:String,
        @Query("key") key:String
    ): Call<PlaylistResponse>
}