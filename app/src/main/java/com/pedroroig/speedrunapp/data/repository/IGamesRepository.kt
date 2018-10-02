package com.pedroroig.speedrunapp.data.repository

import com.pedroroig.speedrunapp.model.entity.GameModel

interface IGamesRepository {

    fun findAll(): List<GameModel>

}