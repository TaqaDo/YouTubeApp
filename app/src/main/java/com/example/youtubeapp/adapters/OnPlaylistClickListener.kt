package com.example.youtubeapp.adapters

import com.example.youtubeapp.models.youtube.Item

interface OnPlaylistClickListener {
    fun onItemClick(item: Item)
}