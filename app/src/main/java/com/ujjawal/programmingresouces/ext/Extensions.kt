package com.ujjawal.programmingresouces.ext

import android.animation.Animator
import android.app.Activity
import android.view.animation.Animation
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.airbnb.lottie.LottieAnimationView
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

fun ShimmerDrawable.getDefaultShimmerDrawable(
    duration: Long = 1500,
    baseAlpha: Float = 0.9f,
    highlightAlpha: Float = 0.8f,
    direction: Int = Shimmer.Direction.LEFT_TO_RIGHT,
    autoStart: Boolean = true
): ShimmerDrawable {
    val shimmer =
        Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
            .setDuration(duration) // how long the shimmering animation takes to do one full sweep
            .setBaseAlpha(baseAlpha) //the alpha of the underlying children
            .setHighlightAlpha(highlightAlpha) // the shimmer alpha amount
            .setDirection(direction)
            .setAutoStart(autoStart)
            .build()

    setShimmer(shimmer)
    return this
}

fun LottieAnimationView.onAnimationCompleted(callback: (Animator) -> Unit) {
    this.addAnimatorListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(p0: Animator) {}

        override fun onAnimationEnd(p0: Animator) {
            callback.invoke(p0)
        }

        override fun onAnimationCancel(p0: Animator) {}

        override fun onAnimationRepeat(p0: Animator) {}
    })
}

fun AppCompatActivity.addFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false,
    tag: String? = null
) {
    val transaction = supportFragmentManager
        .beginTransaction()
    transaction.add(containerId, fragment, tag)
    if (addToBackStack) {
        transaction.addToBackStack(tag)
    }
    transaction.commit()
}

fun AppCompatActivity.replaceFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false,
    tag: String? = null
) {
    val transaction = supportFragmentManager
        .beginTransaction()
    transaction.replace(containerId, fragment, tag)
    if (addToBackStack) {
        transaction.addToBackStack(tag)
    }
    transaction.commit()
}

fun Fragment.addFragment(
    @IdRes containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = false,
    tag: String? = null
) {
    val transaction = childFragmentManager
        .beginTransaction()
    transaction.add(containerId, fragment, tag)
    if (addToBackStack) {
        transaction.addToBackStack(tag)
    }
    transaction.commit()
}

fun Activity.hideSystemBars(){
    val windowInsetsController = ViewCompat.getWindowInsetsController(window.decorView) ?: return
    windowInsetsController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
}