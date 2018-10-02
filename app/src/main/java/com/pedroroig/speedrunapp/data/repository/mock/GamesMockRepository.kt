package com.pedroroig.speedrunapp.data.repository.mock

import com.pedroroig.speedrunapp.data.repository.IGamesRepository
import com.pedroroig.speedrunapp.model.entity.GameModel
import com.pedroroig.speedrunapp.model.mock.mockGame1
import com.pedroroig.speedrunapp.model.mock.mockGame2
import com.pedroroig.speedrunapp.model.mock.mockGame3

@Suppress("unused")
class GamesMockRepository: IGamesRepository {

    override fun findAll(): List<GameModel> {
        return listOf(mockGame1(), mockGame2(), mockGame3())
    }

}