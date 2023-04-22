package com.geektech.youtube12.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.geektech.youtube12.model.playlist.Playlist


@Dao
interface PlaylistDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(playlist: Playlist)

    @Query("SELECT * FROM playlist")
    suspend fun getPlaylist():Playlist
}