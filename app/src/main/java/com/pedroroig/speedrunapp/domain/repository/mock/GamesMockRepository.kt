package com.pedroroig.speedrunapp.domain.repository.mock

import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.mock.mockGame1
import com.pedroroig.speedrunapp.domain.mock.mockGame2
import com.pedroroig.speedrunapp.domain.mock.mockGame3
import com.pedroroig.speedrunapp.domain.repository.IGamesRepository
import io.reactivex.Single
import io.reactivex.SingleObserver

@Suppress("unused")
class GamesMockRepository : IGamesRepository {

    override fun findAll(observer: SingleObserver<List<GameModel>>) {
        val observable = Single.just(listOf(mockGame1(), mockGame2(), mockGame3()))
        observable.subscribe(observer)
    }

}