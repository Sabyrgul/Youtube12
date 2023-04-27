package com.geektech.youtube12.di

import com.geektech.youtube12.ui.detail.DetailViewModel
import com.geektech.youtube12.ui.playlist.PlaylistViewModel
import com.geektech.youtube12.ui.video.VideoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PlaylistViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { VideoViewModel(get()) }
}