package com.geektech.youtube12.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.youtube12.base.BaseViewModel
import com.geektech.youtube12.data.remote.ApiService
import com.geektech.youtube12.data.remote.RetrofitClient
import com.geektech.youtube12.model.playlist.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel:BaseViewModel() {

    private val apiService:ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylistItems(playlistId:String):LiveData<Playlist>{

        val data= MutableLiveData<Playlist>()

        apiService.getPlaylistItems(playlistId = playlistId).enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if(response.isSuccessful){
                    data.value=response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                Log.e("TAG","onFailure: "+t.message)
            }

        })
        return data
    }
}