package com.ujjawal.programmingresouces.view.splash

import android.annotation.SuppressLint
import android.os.Bundle
import com.ujjawal.programmingresouces.R
import com.ujjawal.programmingresouces.architecture.BaseActivity
import com.ujjawal.programmingresouces.databinding.ActivitySplashBinding
import com.ujjawal.programmingresouces.ext.hideSystemBars
import com.ujjawal.programmingresouces.ext.onAnimationCompleted
import com.ujjawal.programmingresouces.view.home.HomeActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemBars()
        binding.lottieAnimationView.setAnimation("splash-animation.json")
        binding.lottieAnimationView.onAnimationCompleted {
            moveToHome()
        }
        binding.lottieAnimationView.playAnimation()
    }

    private fun moveToHome() {
        val homeActivityIntent = HomeActivity.getLaunchIntent(this)
        startActivity(homeActivityIntent)
        finish()
    }
}