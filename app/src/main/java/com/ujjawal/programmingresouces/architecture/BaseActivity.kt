package com.ujjawal.programmingresouces.architecture

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<D: ViewDataBinding>: AppCompatActivity() {

    protected abstract val layoutRes: Int

    protected lateinit var binding: D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutRes)
        binding.lifecycleOwner = this
    }
}