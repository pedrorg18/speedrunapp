package com.pedroroig.speedrunapp.data.repository

import com.pedroroig.speedrunapp.model.entity.GameModel
import com.pedroroig.speedrunapp.model.mock.mockGame1
import com.pedroroig.speedrunapp.model.mock.mockGame2
import com.pedroroig.speedrunapp.model.mock.mockGame3

class GamesRepository: IGamesRepository {

    override fun findAll(): List<GameModel> {
        // FIXME mocks, substitute by real data
        return listOf(mockGame1(), mockGame2(), mockGame3())
    }

}