package com.geektech.youtube12.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.youtube12.base.BaseViewModel
import com.geektech.youtube12.data.Repository
import com.geektech.youtube12.data.remote.Resource
import com.geektech.youtube12.model.playlist.Playlist

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    fun init(){
        getPlaylist()
        getPlaylistDb()
    }
    private val playlistCount= MutableLiveData<Int>()
    private val setPlaylistDbLiveData=MutableLiveData<Playlist>()
    private val getPlaylistDbLiveData=MutableLiveData<Boolean>()
    private var maxResult=5

    val playlist = playlistCount.switchMap {
        repository.getPlaylist(it)
    }
    val getPlaylistDb=getPlaylistDbLiveData.switchMap {
        repository.getPlaylistDb()
    }

    val setPlaylistDb=setPlaylistDbLiveData.switchMap {
        repository.setPlaylistDb(it)
    }

    fun getPlaylist(){
        maxResult += 5
        playlistCount.value=5
    }

    fun getPlaylistDb(){
        getPlaylistDbLiveData.postValue(true)
    }
    fun setPlaylistDb(playlist: Playlist){
        setPlaylistDbLiveData.postValue(playlist)
    }

}