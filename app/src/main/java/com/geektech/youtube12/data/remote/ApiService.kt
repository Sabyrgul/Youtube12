package com.geektech.youtube12.data.remote

import com.geektech.youtube12.BuildConfig
import com.geektech.youtube12.model.Constant
import com.geektech.youtube12.model.playlist.Playlist
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlaylist(
        @Query("key") key:String=BuildConfig.API_KEY,
        @Query("part")part:String= Constant.PART,
        @Query("channelId")channelId:String= Constant.CHANNEL_ID,
        @Query("maxResults")maxResults:Int= Constant.MAX_RESULT
    ): Response<Playlist>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("key") key:String=BuildConfig.API_KEY,
        @Query("part")part:String= Constant.PART,
        @Query("playlistId")playlistId:String,
        @Query("maxResults")maxResults:Int= Constant.MAX_RESULT
    ): Response<Playlist>
}