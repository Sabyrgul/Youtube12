package com.geektech.youtube12.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.paging.PagedList
import com.geektech.youtube12.data.remote.RetrofitClient
import com.geektech.youtube12.model.playlist.Item
import com.geektech.youtube12.model.playlist.Playlist
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService = RetrofitClient.create()


    fun getPlaylistItems(playlistId: String): LiveData<Playlist> = liveData(Dispatchers.IO) {

        val result = apiService.getPlaylistItems(playlistId = playlistId)
        if (result.isSuccessful) {
            result.body()?.let { emit(it) }
        } else {
            Log.e("TAG", "getPlaylist: " + result.message())
        }
    }

    fun getPlaylist(): LiveData<Playlist> = liveData(Dispatchers.IO) {

        val result = apiService.getPlaylist()
        if (result.isSuccessful) {
            result.body()?.let { emit(it) }
        } else {
            Log.e("TAG", "getPlaylist: " + result.message())
        }
    }
}