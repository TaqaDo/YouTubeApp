package com.example.youtubeapp.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.youtubeapp.models.youtube.Item

@Dao
interface YoutubeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPlaylist(list: List<Item>)

    @Query("SELECT * FROM Item")
    fun getAllPlaylist(): List<Item>
}