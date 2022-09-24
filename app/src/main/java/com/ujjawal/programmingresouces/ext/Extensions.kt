package com.ujjawal.programmingresouces.ext

import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable

fun ShimmerDrawable.getDefaultShimmerDrawable(
    duration: Long = 1500,
    baseAlpha: Float = 0.9f,
    highlightAlpha: Float = 0.8f,
    direction: Int = Shimmer.Direction.LEFT_TO_RIGHT,
    autoStart: Boolean = true
): ShimmerDrawable {
    val shimmer = Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
        .setDuration(duration) // how long the shimmering animation takes to do one full sweep
        .setBaseAlpha(baseAlpha) //the alpha of the underlying children
        .setHighlightAlpha(highlightAlpha) // the shimmer alpha amount
        .setDirection(direction)
        .setAutoStart(autoStart)
        .build()

    setShimmer(shimmer)
    return this
}