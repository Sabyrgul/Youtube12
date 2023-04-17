package com.geektech.youtube12.ui.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import com.geektech.youtube12.base.BaseViewModel
import com.geektech.youtube12.data.Repository
import com.geektech.youtube12.data.remote.RetrofitClient
import com.geektech.youtube12.model.playlist.Item
import com.geektech.youtube12.model.playlist.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val repository = Repository()

    val playlist: LiveData<Playlist> = repository.getPlaylist()
}