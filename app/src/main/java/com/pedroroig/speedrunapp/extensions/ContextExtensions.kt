package com.pedroroig.speedrunapp.extensions

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

val Activity.ctx: Context
get() = this

val View.ctx: Context
    get() = context

