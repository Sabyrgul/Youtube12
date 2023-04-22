package com.geektech.youtube12.ui.detail

import com.geektech.youtube12.base.BaseViewModel
import com.geektech.youtube12.data.Repository

class DetailViewModel(private val repository: Repository):BaseViewModel() {


    fun getPlaylistItems(id:String)=repository.getPlaylistItems(id)
}