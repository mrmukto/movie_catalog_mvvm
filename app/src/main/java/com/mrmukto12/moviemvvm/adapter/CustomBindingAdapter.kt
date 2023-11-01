package com.mrmukto12.moviemvvm.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("app:setMovieImage")
fun setImage(imageView: ImageView, icon: String?) {
    icon?.let {
        val url = icon
        Glide
            .with(imageView.context)
            .load(url)
            .into(imageView)
    }
}

