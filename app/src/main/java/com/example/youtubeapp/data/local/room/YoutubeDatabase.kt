package com.example.youtubeapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.youtubeapp.models.youtube.Item
import com.example.youtubeapp.utills.Converters


@Database(
        entities = [Item::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(Converters::class)
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