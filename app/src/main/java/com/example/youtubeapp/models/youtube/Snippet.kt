package com.example.youtubeapp.models.youtube

import androidx.room.TypeConverters
import com.example.youtubeapp.utills.Converters

data class Snippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val localized: Localized,
    val publishedAt: String,
    @TypeConverters(Converters::class)
    val thumbnails: Thumbnails,
    val title: String
)