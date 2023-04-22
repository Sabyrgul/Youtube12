package com.geektech.youtube12.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geektech.youtube12.App
import com.geektech.youtube12.data.local.AppDataBase
import com.geektech.youtube12.data.remote.ApiService
import com.geektech.youtube12.data.remote.Resource
import com.geektech.youtube12.model.playlist.Playlist
import kotlinx.coroutines.Dispatchers

class Repository (private val apiService: ApiService, private val db:AppDataBase){


    fun getPlaylistItems(playlistId: String): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.getPlaylistItems(playlistId = playlistId)
        if (result.isSuccessful) {
            Resource.success(result.body())?.let { emit(it) }
        } else {
            emit(Resource.error(result.message()))
        }
    }

    fun getPlaylist(maxResult:Int): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val result = apiService.getPlaylist(maxResults = maxResult)
        if (result.isSuccessful) {
            Resource.success(result.body())?.let { emit(it) }
        } else {
            emit(Resource.error(result.message()))
        }
    }

    fun setPlaylistDb(playlist: Playlist):LiveData<Resource<Boolean>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        db.dao().insert(playlist)
        Resource.success(true)?.let { emit(it) }
    }

    fun getPlaylistDb():LiveData<Resource<Playlist>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val result= db.dao().getPlaylist()
        Resource.success(result)?.let { emit(it) }
    }
}