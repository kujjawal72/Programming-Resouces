package com.ujjawal.programmingresouces.view.home

import android.os.Bundle
import android.view.View
import com.ujjawal.programmingresouces.R
import com.ujjawal.programmingresouces.architecture.BaseFragment
import com.ujjawal.programmingresouces.databinding.FragmentResourceSearchAndFilterBinding
import com.ujjawal.programmingresouces.viewmodel.HomeViewModel

class ResourceSearchAndFilterFragment : BaseFragment<HomeViewModel, FragmentResourceSearchAndFilterBinding>() {

    companion object {
        fun newInstance() = ResourceSearchAndFilterFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_resource_search_and_filter

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}