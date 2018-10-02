package com.pedroroig.speedrunapp.data.repository

import com.pedroroig.speedrunapp.domain.entity.GameModel

interface IGamesRepository {

    fun findAll(): List<GameModel>

}