package com.example.youtubeapp.models.youtube

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
data class Item(

        @PrimaryKey
        val id: String,
        val contentDetails: ContentDetails,
        val etag: String,
        val kind: String,
        val snippet: Snippet
) : Serializable