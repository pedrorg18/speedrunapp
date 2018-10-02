package com.pedroroig.speedrunapp.domain.repository

import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.entity.RunModel
import io.reactivex.SingleObserver

interface IGamesRepository {

    fun findAll(observer: SingleObserver<List<GameModel>>)
    fun findBestRun(gameId: String, observer: SingleObserver<RunModel>)
}