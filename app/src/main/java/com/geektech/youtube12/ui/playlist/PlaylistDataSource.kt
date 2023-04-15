package com.geektech.youtube12.ui.playlist
//
//import androidx.paging.ItemKeyedDataSource
//import androidx.paging.PageKeyedDataSource
//import com.geektech.youtube12.model.playlist.Item
//
//class PlaylistDataSource:PageKeyedDataSource<Int,Item>() {
//
//    override fun getKey(item: Item): Int =item.id.toString()
//    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Item>) {
//        val items = fetchItems(params.requestedInitialKey,
//            params.requestedLoadSize)
//        callback.onResult(items)
//    }
//
//    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Item>) {
//        val items = fetchItemsAfter(
//            date = params.key,
//            limit = params.requestedLoadSize)
//        callback.onResult(items)
//    }
//
//    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Item>) {
//        TODO("Not yet implemented")
//    }
//
//
//}