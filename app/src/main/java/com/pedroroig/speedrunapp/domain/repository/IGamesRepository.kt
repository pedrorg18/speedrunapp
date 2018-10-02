package com.pedroroig.speedrunapp.domain.repository

import com.pedroroig.speedrunapp.domain.entity.GameModel
import io.reactivex.SingleObserver

interface IGamesRepository {

    fun findAll(observer: SingleObserver<List<GameModel>>)

}