package com.pedroroig.speedrunapp.data.repository.mock

import com.pedroroig.speedrunapp.data.repository.IGamesRepository
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.mock.mockGame1
import com.pedroroig.speedrunapp.domain.mock.mockGame2
import com.pedroroig.speedrunapp.domain.mock.mockGame3

@Suppress("unused")
class GamesMockRepository: IGamesRepository {

    override fun findAll(): List<GameModel> {
        return listOf(mockGame1(), mockGame2(), mockGame3())
    }

}