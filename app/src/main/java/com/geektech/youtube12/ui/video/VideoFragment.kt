package com.geektech.youtube12.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.geektech.youtube12.R
import com.geektech.youtube12.base.BaseFragment
import com.geektech.youtube12.databinding.FragmentVideoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class VideoFragment : BaseFragment<FragmentVideoBinding,VideoViewModel>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentVideoBinding {
        return FragmentVideoBinding.inflate(inflater,container,false)
    }

    override fun initListeners() {
        TODO("Not yet implemented")
    }

    override fun initViews() {
        TODO("Not yet implemented")
    }


    override val viewModel: VideoViewModel by viewModel()
    override fun initObservers() {
        TODO("Not yet implemented")
    }


}