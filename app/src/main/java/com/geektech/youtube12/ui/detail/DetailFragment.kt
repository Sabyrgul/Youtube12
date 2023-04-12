package com.geektech.youtube12.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.geektech.youtube12.R
import com.geektech.youtube12.base.BaseFragment
import com.geektech.youtube12.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding,DetailViewModel>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater,container,false)
    }

    override fun initListeners() {
        TODO("Not yet implemented")
    }

    override fun initViews() {
       val id=arguments?.getString("id")
        viewModel.getPlaylistItems(id.toString()).observe(viewLifecycleOwner){

        }
    }


    override val viewModel: DetailViewModel by lazy{
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    override fun initViewModel() {
        TODO("Not yet implemented")
    }

}