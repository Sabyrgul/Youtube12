package com.geektech.youtube12.ui.playlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.geektech.youtube12.NetworkConnection
import com.geektech.youtube12.R
import com.geektech.youtube12.base.BaseFragment
import com.geektech.youtube12.data.remote.Status
import com.geektech.youtube12.databinding.FragmentPlaylistBinding
import com.geektech.youtube12.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private val adapter: PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick)
    }

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

        initRecyclerView()
    }

    fun initRecyclerView(){
        binding.rvPlaylist.adapter = adapter
        viewModel.playlist.observe(viewLifecycleOwner) {
            adapter.addData(it.data?.items)
        }

        binding.rvPlaylist.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (recyclerView.canScrollVertically(1)) {
                    showToast("Last")
                    viewModel.getPlaylist()
                }
            }
        })
    }

    private fun onClick(id: String) {
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
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

    }