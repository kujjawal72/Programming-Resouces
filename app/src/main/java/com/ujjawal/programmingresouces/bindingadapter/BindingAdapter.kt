package com.ujjawal.programmingresouces.bindingadapter

import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.facebook.shimmer.ShimmerDrawable
import com.ujjawal.programmingresouces.ext.getDefaultShimmerDrawable

private const val TAG = "BindingAdapter"

@BindingAdapter("imageUrl", "placeholder")
fun loadImageOrUseDrawable(imageView: ImageView,imageUrl : String?, placeholder : Drawable?){
    if(placeholder == null){
        return
    }
    try {
        with(imageView){
            if(imageUrl.isNullOrEmpty()){
                setImageDrawable(placeholder)
            }else{
                val shimmerDrawable = ShimmerDrawable().getDefaultShimmerDrawable()
                Glide.with(this)
                    .load(imageUrl)
                    .placeholder(shimmerDrawable)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .error(placeholder)
                    .into(this)
            }
        }
    }catch (ex: Exception) {
        imageView.setImageDrawable(placeholder)
        Log.d(TAG, "loadImageOrUseDrawable: $ex")
    }
}