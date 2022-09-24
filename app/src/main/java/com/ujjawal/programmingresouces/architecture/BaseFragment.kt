package com.ujjawal.programmingresouces.architecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<V: ViewModel, D: ViewDataBinding>: Fragment() {

    protected abstract val layoutRes: Int
    protected abstract fun getViewModel(): Class<V>

    protected lateinit var binding: D
    protected lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[getViewModel()]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,layoutRes,container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}