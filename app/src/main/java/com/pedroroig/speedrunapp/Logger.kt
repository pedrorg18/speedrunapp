package com.pedroroig.speedrunapp

import android.util.Log

internal object Logger {

    private const val COMMON_TAG = "COMMON_TAG"

    fun i(text: String) {
        Log.i(COMMON_TAG, text)
    }
}
