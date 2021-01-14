package com.example.youtubeapp.models.youtube

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.youtubeapp.utills.Converters
import java.io.Serializable


@Entity
data class Item(

        @PrimaryKey
        val id: String,
        @TypeConverters(Converters::class)
        val contentDetails: ContentDetails,
        val etag: String,
        val kind: String,
        @TypeConverters(Converters::class)
        val snippet: Snippet
) : Serializable