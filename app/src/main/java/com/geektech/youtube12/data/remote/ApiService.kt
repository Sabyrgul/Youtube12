package com.geektech.youtube12.data.remote

import com.geektech.youtube12.BuildConfig
import com.geektech.youtube12.model.`object`.Constant
import com.geektech.youtube12.model.playlist.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylist(
        @Query("key") key:String=BuildConfig.API_KEY,
        @Query("part")part:String=Constant.PART,
        @Query("channelId")channelId:String=Constant.CHANNEL_ID,
        @Query("maxResults")maResults:String=Constant.MAX_RESULT
    ): Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistItems(
        @Query("key") key:String=BuildConfig.API_KEY,
        @Query("part")part:String=Constant.PART,
        @Query("channelId")playlistId:String,
        @Query("maxResults")maResults:String=Constant.MAX_RESULT
    ): Call<Playlist>
}