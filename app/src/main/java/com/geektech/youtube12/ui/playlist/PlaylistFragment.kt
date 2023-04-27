package com.geektech.youtube12.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.geektech.youtube12.NetworkConnection
import com.geektech.youtube12.R
import com.geektech.youtube12.base.BaseFragment
import com.geektech.youtube12.data.remote.Status
import com.geektech.youtube12.databinding.FragmentPlaylistBinding
import com.geektech.youtube12.model.ItemDetail
import com.geektech.youtube12.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private lateinit var adapter: PlaylistAdapter

    override val viewModel: PlaylistViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initListeners() {

    }

    override fun initViews() {
        adapter = PlaylistAdapter(requireContext(), this::onItemClick)
        binding.rvPlaylist.adapter = adapter
    }

    override fun initObservers() {
        val networkConnection = NetworkConnection(requireContext())
        networkConnection.observe(this) {
            if (it) {
                viewModel.playlist.observe(viewLifecycleOwner) {
                    binding.progressBar.isVisible = it.status == Status.LOADING
                    when (it.status) {
                        Status.SUCCESS -> {
                            it.data?.let { it1 -> viewModel.setPlaylistDb(it1) }
                            adapter.addData(it.data?.items)
                        }
                        Status.ERROR -> {
                            showToast(it.data?.etag.toString())// on stream it was msg, but i couldn't find it.msg
                        }
                        else -> {}
                    }

                }
            }
        }
        viewModel.setPlaylistDb.observe(viewLifecycleOwner) {

        }
        viewModel.getPlaylistDb.observe(viewLifecycleOwner) {

        }
    }

    private fun onItemClick(id: String, itemDetail: ItemDetail) {
        val title=itemDetail.title
        val description = itemDetail.description
        val videoCount=itemDetail.videoCount

        findNavController().navigate(R.id.detailFragment
            , bundleOf("id" to id, "title" to title,
                         "description" to description, "videoCount" to videoCount))
    }

}

