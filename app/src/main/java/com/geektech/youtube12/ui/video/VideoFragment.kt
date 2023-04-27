package com.geektech.youtube12.ui.video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.youtube12.R
import com.geektech.youtube12.base.BaseFragment
import com.geektech.youtube12.databinding.FragmentVideoBinding
import com.geektech.youtube12.ui.detail.DetailFragment
import com.geektech.youtube12.utils.youtubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel


class VideoFragment : BaseFragment<FragmentVideoBinding, VideoViewModel>() {

    override val viewModel: VideoViewModel by viewModel()

    override fun inflateViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): FragmentVideoBinding {
        return FragmentVideoBinding.inflate(inflater, container, false)
    }

    override fun initListeners() {
        binding.tvBack.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.tvPlaylist.setOnClickListener {
            findNavController().navigate(R.id.playlistFragment)
        }
    }

    override fun initViews() {
        val videoId = arguments?.getString(DetailFragment.VIDEO_ID, "").toString()
        val videoTitle = arguments?.getString(DetailFragment.VIDEO_TITLE).toString()
        val videoDescription = arguments?.getString(DetailFragment.VIDEO_DESCRIPTION).toString()

        lifecycle.addObserver(binding.youtubePlayerView)
        val options: IFramePlayerOptions = IFramePlayerOptions.Builder().controls(0).build()
        val listener: YouTubePlayerListener = object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                // using pre-made custom ui
                val defaultPlayerUiController =
                    DefaultPlayerUiController(binding.youtubePlayerView, youTubePlayer)
                binding.youtubePlayerView.setCustomPlayerUi(defaultPlayerUiController.rootView)
                youTubePlayer.loadVideo(videoId, 0f)
                youTubePlayer.play()
            }
        }
        binding.apply {
            youtubePlayerView.initialize(listener, options)
            tvVideoTitle.text = videoTitle
            tvDescription.text = videoDescription
        }

    }

    override fun initObservers() {

    }


}