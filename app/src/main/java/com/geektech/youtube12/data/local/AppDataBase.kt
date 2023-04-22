package com.geektech.youtube12.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geektech.youtube12.model.playlist.Playlist

@Database(entities = [Playlist::class], version = 1)

@TypeConverters(Converter::class)
abstract class AppDataBase:RoomDatabase() {

    abstract fun dao():PlaylistDao
}