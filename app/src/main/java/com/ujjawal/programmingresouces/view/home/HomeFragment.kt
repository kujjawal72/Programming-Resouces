package com.ujjawal.programmingresouces.view.home

import android.os.Bundle
import android.view.View
import com.ujjawal.programmingresouces.R
import com.ujjawal.programmingresouces.architecture.BaseFragment
import com.ujjawal.programmingresouces.databinding.FragmentHomeBinding
import com.ujjawal.programmingresouces.ext.addFragment
import com.ujjawal.programmingresouces.viewmodel.HomeViewModel


class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override val layoutRes: Int = R.layout.fragment_home

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFragment(R.id.searchAndFilterContainer, ResourceSearchAndFilterFragment.newInstance())
    }
}