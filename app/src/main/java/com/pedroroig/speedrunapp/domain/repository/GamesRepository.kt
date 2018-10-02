package com.pedroroig.speedrunapp.domain.repository

import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.mock.mockGame1
import com.pedroroig.speedrunapp.domain.mock.mockGame2
import com.pedroroig.speedrunapp.domain.mock.mockGame3

class GamesRepository: IGamesRepository {

    override fun findAll(): List<GameModel> {
        // FIXME mocks, substitute by real data
        return listOf(mockGame1(), mockGame2(), mockGame3())
    }

}