package com.pedroroig.speedrunapp.domain.entity

import java.io.Serializable

data class GameModel(
        val id: String,
        val name: String,
        val imageLocation: String) : Serializable