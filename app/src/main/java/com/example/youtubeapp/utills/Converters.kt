package com.example.youtubeapp.utills

import androidx.room.TypeConverter
import com.example.youtubeapp.models.youtube.ContentDetails
import com.example.youtubeapp.models.youtube.Medium
import com.example.youtubeapp.models.youtube.Snippet
import com.example.youtubeapp.models.youtube.Thumbnails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromContent(data: String?): ContentDetails? {
        if(data == null) return null
        val gson = Gson()
        val type = object : TypeToken<ContentDetails?>() {}.type
        return gson.fromJson<ContentDetails>(data, type)
    }

    @TypeConverter
    fun toContent(contentDetails: ContentDetails?): String? {
        if(contentDetails == null) return null
        val gson = Gson()
        val type = object : TypeToken<ContentDetails?>() {}.type
        return gson.toJson(contentDetails, type)
    }

    @TypeConverter
    fun fromThumbnails(data: String?): Thumbnails? {
        if(data == null) return null
        val gson = Gson()
        val type = object : TypeToken<ContentDetails?>() {}.type
        return gson.fromJson<Thumbnails>(data, type)
    }

    @TypeConverter
    fun toThumbnails(thumbnails: Thumbnails?): String? {
        if(thumbnails == null) return null
        val gson = Gson()
        val type = object : TypeToken<ContentDetails?>() {}.type
        return gson.toJson(thumbnails, type)
    }

    @TypeConverter
    fun fromMedium(raw: String?): Medium? {
        if (raw == null) return null
        val gson = Gson()
        val type = object : TypeToken<Medium?>() {}.type
        return gson.fromJson<Medium>(raw, type)
    }

    @TypeConverter
    fun toMedium(medium: Medium?): String? {
        if (medium == null) return null
        val gson = Gson()
        val type = object : TypeToken<Medium?>() {}.type
        return gson.toJson(medium, type)
    }

    @TypeConverter
    fun fromSnippet(raw: String?): Snippet? {
        if (raw == null) return null
        val gson = Gson()
        val type = object : TypeToken<Snippet?>() {}.type
        return gson.fromJson<Snippet>(raw, type)
    }

    @TypeConverter
    fun toSnippet(snippet: Snippet?): String? {
        if (snippet == null) return null
        val gson = Gson()
        val type = object : TypeToken<Snippet?>() {}.type
        return gson.toJson(snippet, type)
    }


}