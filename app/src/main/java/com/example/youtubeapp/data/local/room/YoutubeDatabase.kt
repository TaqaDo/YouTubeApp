package com.example.youtubeapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.youtubeapp.models.youtube.Item


@Database(
        entities = [Item::class],
        version = 1,
        exportSchema = false
)
abstract class YoutubeDatabase: RoomDatabase() {

    abstract fun youTubedao(): YoutubeDao

    companion object {
        @Volatile
        private var INSTANCE: YoutubeDatabase? = null

        fun getDatabase(context: Context): YoutubeDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        YoutubeDatabase::class.java,
                        "youtube_database"
                )
                        .allowMainThreadQueries()
                        .build()
                INSTANCE = instance

                instance
            }
        }

    }
}