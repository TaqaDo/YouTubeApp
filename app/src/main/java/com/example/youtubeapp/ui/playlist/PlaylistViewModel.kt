package com.example.youtubeapp.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapp.models.resource_courutines.Resource
import com.example.youtubeapp.models.youtube.PlaylistResponse
import com.example.youtubeapp.repository.YoutubeNetworkRepository

class PlaylistViewModel : ViewModel() {
    var repo = YoutubeNetworkRepository()

    fun fetchPlaylistFromServer(): LiveData<Resource<PlaylistResponse>> {
        return repo.fetchPlaylists()
    }

    fun fetchNextPlaylist(nextPageToken: String): LiveData<Resource<PlaylistResponse>>{
        return repo.fetchNextPlaylist(nextPageToken)
    }
}