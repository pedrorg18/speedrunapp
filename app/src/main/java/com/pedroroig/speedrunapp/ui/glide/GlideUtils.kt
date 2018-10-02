package com.pedroroig.speedrunapp.ui.glide

import android.widget.ImageView
import com.pedroroig.speedrunapp.R
import com.pedroroig.speedrunapp.extensions.ctx

fun showImage(url: String?, targetView: ImageView) {
    GlideApp.with(targetView.ctx)
            .load(url)
            .placeholder(R.drawable.default_image)
            .into(targetView)
}