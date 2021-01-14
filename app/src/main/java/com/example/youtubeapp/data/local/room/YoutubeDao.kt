package com.example.youtubeapp.data.local.room

import androidx.room.*
import com.example.youtubeapp.models.youtube.Item

@Dao
interface YoutubeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDetailsList(list: MutableList<Item>)

    @Query("SELECT * FROM Item")
    fun getDetailslist(): MutableList<Item>

    @Query("DELETE FROM Item")
    fun deleteAll()
}