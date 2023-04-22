//package com.geektech.youtube12.ui.detail
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.view.isVisible
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.RecyclerView
//import com.geektech.youtube12.R
//import com.geektech.youtube12.base.BaseFragment
//import com.geektech.youtube12.data.remote.Status
//import com.geektech.youtube12.databinding.FragmentDetailBinding
//import com.geektech.youtube12.ui.playlist.PlaylistAdapter
//import com.geektech.youtube12.ui.playlist.PlaylistViewModel
//import com.geektech.youtube12.utils.showToast
//import org.koin.androidx.viewmodel.ext.android.viewModel
//
//class DetailFragment : BaseFragment<FragmentDetailBinding,DetailViewModel>() {
//
//    private val adapter: DetailAdapter by lazy {
//      //  DetailAdapter(this::onClick)
//    }
//    override fun inflateViewBinding(
//        inflater: LayoutInflater,
//        container: ViewGroup?
//    ): FragmentDetailBinding {
//        return FragmentDetailBinding.inflate(inflater,container,false)
//    }
//
//    override fun initListeners() {
//
//    }
//
//    override fun initViews() {
//        initRecyclerView()
//
//    }
//
//
//    fun initRecyclerView(){
//        binding.recyclerView.adapter = adapter
//      //  viewModel.getPlaylistItems(id).observe(viewLifecycleOwner) {
//            adapter.addData(it.data?.items)
//        }
//
//        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (recyclerView.canScrollVertically(1)) {
//                    showToast("Last")
//                  //  viewModel.getPlaylistItems()
//                }
//            }
//        })
//    }
//    override val viewModel: DetailViewModel by viewModel()
//
//
//    override fun initObservers() {
//
//        val id=arguments?.getString("id")
//        viewModel.getPlaylistItems(id.toString()).observe(viewLifecycleOwner){
//            binding.progressBar.isVisible = it.status == Status.LOADING
//        }
//    }
//
//}