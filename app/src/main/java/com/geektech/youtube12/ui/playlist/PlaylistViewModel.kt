package com.geektech.youtube12.ui.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.youtube12.base.BaseViewModel
import com.geektech.youtube12.data.remote.RetrofitClient
import com.geektech.youtube12.model.playlist.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel:BaseViewModel() {

    private val apiService=RetrofitClient.create()
    private val playlistLiveData=MutableLiveData<Playlist>()
  //

    fun getPlaylist():LiveData<Playlist>{

        val data=MutableLiveData<Playlist>()

        apiService.getPlaylist().enqueue(object :Callback<Playlist>{
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if(response.isSuccessful){
                    playlistLiveData.value=response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
               Log.e("TAG","onFailure: "+t.message)
            }

        })
        return data
    }
}