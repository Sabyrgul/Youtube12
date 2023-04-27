package com.geektech.youtube12.ui.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.geektech.youtube12.base.BaseViewModel
import com.geektech.youtube12.data.Repository
import com.geektech.youtube12.model.playlist.Playlist

class PlaylistViewModel(private val repository: Repository) : BaseViewModel() {

    private val playlistLiveData = MutableLiveData<Boolean>()
    private val setPlaylistDbLiveData = MutableLiveData<Playlist>()
    private val getPlaylistDbLiveData = MutableLiveData<Boolean>()

    init {
        getPlaylist()
        getPlaylistDb()
    }

    val playlist = playlistLiveData.switchMap {
        repository.getPlaylist(20)
    }
    val getPlaylistDb = getPlaylistDbLiveData.switchMap {
        repository.getPlaylistDb()
    }

    val setPlaylistDb = setPlaylistDbLiveData.switchMap {
        repository.setPlaylistDb(it)
    }

    fun getPlaylist() {
        playlistLiveData.postValue(true)
    }

    fun getPlaylistDb() {
        getPlaylistDbLiveData.postValue(true)
    }

    fun setPlaylistDb(playlist: Playlist) {
        setPlaylistDbLiveData.postValue(playlist)
    }

}