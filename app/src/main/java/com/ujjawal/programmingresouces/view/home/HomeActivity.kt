package com.ujjawal.programmingresouces.view.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.ujjawal.programmingresouces.R
import com.ujjawal.programmingresouces.architecture.BaseActivity
import com.ujjawal.programmingresouces.databinding.ActivityHomeBinding
import com.ujjawal.programmingresouces.ext.addFragment
import com.ujjawal.programmingresouces.model.Constants

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    companion object {
        fun getLaunchIntent(context: Context, bundle: Bundle? = null) =
            Intent(context, HomeActivity::class.java).apply {
                putExtra(Constants.INTENT_DATA, bundle)
            }
    }

    override val layoutRes: Int = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.navHeader.user = Constants.Default.user
        addFragment(
            containerId = R.id.container,
            fragment = HomeFragment.newInstance(),
            tag = HomeFragment::class.java.simpleName
        )
    }

    fun handleDrawerLayoutOpenCloseAction() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START, true)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START, true)
        }
    }
}