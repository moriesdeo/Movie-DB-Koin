package com.test.core.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

/**
 * @author mories.deo
 * @date 19-Jul-2023
 */

fun ImageView.loadImage(img: String?) {
    Glide.with(this).load(img).into(this)
}

fun ImageView.loadImageDrawableResource(@DrawableRes resource: Int?) {
    Glide.with(this).load(resource).into(this)
}

fun ImageView.loadImageWithPlaceholder(
    imgUrl: String?,
    @DrawableRes placeholder: Int){
    Glide.with(this)
        .load(imgUrl)
        .placeholder(placeholder)
        .into(this)
}