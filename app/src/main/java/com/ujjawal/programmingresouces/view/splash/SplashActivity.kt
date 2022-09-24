package com.ujjawal.programmingresouces.view.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ujjawal.programmingresouces.R
import com.ujjawal.programmingresouces.architecture.BaseActivity
import com.ujjawal.programmingresouces.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {
    override val layoutRes: Int
        get() = R.layout.activity_splash
}