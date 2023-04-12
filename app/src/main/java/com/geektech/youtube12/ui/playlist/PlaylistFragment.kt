package com.geektech.youtube12.ui.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.geektech.youtube12.R
import com.geektech.youtube12.base.BaseFragment
import com.geektech.youtube12.databinding.FragmentPlaylistBinding

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding,PlaylistViewModel>(){

   private val adapter:PlaylistAdapter by lazy {
       PlaylistAdapter(this::onClick)
   }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater,container,false)
    }

    override fun initListeners() {

    }

    override fun initViews() {
        viewModel.getPlaylist()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPlaylist().observe(viewLifecycleOwner){
            adapter.addData(it.items)
        }
        binding.rvPlaylist.adapter=adapter
    }
    override fun initViewModel() {

    }

    private fun onClick(id:String){
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
    }


}