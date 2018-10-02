package com.pedroroig.speedrunapp.domain.repository

import com.pedroroig.speedrunapp.domain.entity.GameModel

interface IGamesRepository {

    fun findAll(): List<GameModel>

}