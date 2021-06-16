package com.h5190036.h5190036_yunusemresamat_kotlinfinal.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.resimCek(url: String){

    Glide.with(this.context)
        .load(url)
        .into(this)
}