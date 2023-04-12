package com.geektech.youtube12.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB : ViewBinding,VM:BaseViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected abstract val viewModel:VM

    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun initListeners()

    abstract fun initViews()

    abstract fun initViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=inflateViewBinding(inflater,container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initViewModel()
    }


}