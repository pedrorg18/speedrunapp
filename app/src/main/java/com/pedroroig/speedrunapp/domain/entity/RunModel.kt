package com.pedroroig.speedrunapp.domain.entity

data class RunModel (
        val videoLocation: String,
        var userName: String,
        val bestTime: Float
)