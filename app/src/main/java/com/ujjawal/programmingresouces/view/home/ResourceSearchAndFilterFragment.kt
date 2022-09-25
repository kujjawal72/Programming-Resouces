package com.ujjawal.programmingresouces.view.home

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import com.ujjawal.programmingresouces.R
import com.ujjawal.programmingresouces.architecture.BaseFragment
import com.ujjawal.programmingresouces.databinding.FragmentResourceSearchAndFilterBinding
import com.ujjawal.programmingresouces.ext.onAnimationCompleted
import com.ujjawal.programmingresouces.model.Constants
import com.ujjawal.programmingresouces.viewmodel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ResourceSearchAndFilterFragment : BaseFragment<HomeViewModel, FragmentResourceSearchAndFilterBinding>() {

    companion object {
        fun newInstance() = ResourceSearchAndFilterFragment()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_resource_search_and_filter

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgUserImage.setOnClickListener {
            (activity as? HomeActivity)?.handleDrawerLayoutOpenCloseAction()
        }
        binding.profileImageUrl = Constants.Default.user.profileImageUrl
        setMultipleQueryHints()
    }

    private fun setMultipleQueryHints() {
        lifecycleScope.launch {
            var index = 0
            val interestedTopics = Constants.Default.interestedTopics
            while (true){
                if(index == interestedTopics.size-1){
                    index = 0
                }
                binding.searchView.queryHint = interestedTopics[index]
                index++
                delay(3_000)
            }
        }
    }
}