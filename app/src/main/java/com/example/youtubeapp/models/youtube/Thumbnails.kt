package com.example.youtubeapp.models.youtube

import androidx.room.TypeConverters
import com.example.youtubeapp.utills.Converters

data class Thumbnails(
    val default: Default,
    val high: High,
    val maxres: Maxres,
    @TypeConverters(Converters::class)
    val medium: Medium,
    val standard: Standard
)