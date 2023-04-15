package com.geektech.youtube12.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.geektech.youtube12.base.BaseViewModel
import com.geektech.youtube12.data.Repository
import com.geektech.youtube12.data.remote.ApiService
import com.geektech.youtube12.data.remote.RetrofitClient
import com.geektech.youtube12.model.playlist.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel:BaseViewModel() {

    private val repository= Repository()

    fun getPlaylistItems(id:String)=repository.getPlaylistItems(id)
}