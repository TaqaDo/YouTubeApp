package com.example.youtubeapp.models.youtube

import java.io.Serializable

data class Item(
    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet
): Serializable