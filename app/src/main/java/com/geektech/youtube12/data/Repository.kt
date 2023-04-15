package com.geektech.youtube12.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.geektech.youtube12.data.remote.RetrofitClient
import com.geektech.youtube12.model.playlist.Item
import com.geektech.youtube12.model.playlist.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService= RetrofitClient.create()


    fun getPlaylistItems(playlistId:String):LiveData<Playlist>{

        val playlistItems= MutableLiveData<Playlist>()

        apiService.getPlaylistItems(playlistId = playlistId).enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if(response.isSuccessful){
                    playlistItems.value=response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("TAG","onFailure: "+t.message)
            }

        })
        return playlistItems
    }

    fun getPlaylist(): LiveData<Playlist> {

        val playlistLiveData= MutableLiveData<Playlist>()

        apiService.getPlaylist().enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if(response.isSuccessful){
                    playlistLiveData.value=response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("TAG","onFailure: "+t.message)
            }

        })
        return playlistLiveData
    }
}