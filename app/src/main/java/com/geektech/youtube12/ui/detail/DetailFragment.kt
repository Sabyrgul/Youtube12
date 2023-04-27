package com.geektech.youtube12.ui.detail

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.geektech.youtube12.NetworkConnection
import com.geektech.youtube12.R
import com.geektech.youtube12.base.BaseFragment
import com.geektech.youtube12.data.remote.Status
import com.geektech.youtube12.databinding.FragmentDetailBinding
import com.geektech.youtube12.model.ItemDetail
import com.geektech.youtube12.model.playlist.Item
import com.geektech.youtube12.ui.playlist.PlaylistAdapter
import com.geektech.youtube12.utils.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("CAST_NEVER_SUCCEEDS")
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {


    private lateinit var adapter: DetailAdapter

    override val viewModel: DetailViewModel by viewModel()


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }

    override fun initListeners() {
        binding.tvBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvPlaylist.setOnClickListener {
            findNavController().navigate(R.id.playlistFragment)
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun initViews() {

        binding.tvMainTitle.text = arguments?.getString("title")
        binding.tvDescription.text = arguments?.getString("description")
        binding.tvVideoCount.text = arguments?.getString("videoCount")

        adapter = DetailAdapter(requireContext(), this::onClick)
        binding.recyclerView.adapter = adapter
    }

    override fun initObservers() {

        val id = arguments?.getString("id")
        val networkConnection = NetworkConnection(requireContext())
        networkConnection.observe(this) {
            if (it) {
                viewModel.getPlaylistItems(id.toString()).observe(viewLifecycleOwner) {
                    adapter.addData(it.data?.items)
                    binding.progressBar.isVisible = it.status == Status.LOADING
                    adapter.addData(it.data?.items)
                }
            }
        }

    }

    private fun onClick(item: Item) {
        findNavController().navigate(R.id.videoFragment, bundleOf(
            DetailFragment.VIDEO_ID to item.snippet?.resourceId?.videoId,
            DetailFragment.VIDEO_TITLE to item.snippet?.title,
            DetailFragment.VIDEO_DESCRIPTION to item.snippet?.description
        ))
    }

    companion object{
        const val VIDEO_ID="video_id"
        const val VIDEO_TITLE="video_title"
        const val VIDEO_DESCRIPTION="video_description"
    }

}


