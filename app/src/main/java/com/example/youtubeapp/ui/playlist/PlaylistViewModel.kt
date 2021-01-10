package com.example.youtubeapp.ui.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeapp.models.youtube.PlaylistResponse
import com.example.youtubeapp.repository.YoutubeRepository

class PlaylistViewModel : ViewModel() {
    var repo = YoutubeRepository()

    fun fetchPlaylistFromServer(): MutableLiveData<PlaylistResponse> {
        return repo.fetchPlaylistFromServer()
    }
}