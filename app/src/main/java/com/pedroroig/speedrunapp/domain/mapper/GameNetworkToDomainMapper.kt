package com.pedroroig.speedrunapp.domain.mapper

import com.pedroroig.speedrunapp.data.network.entity.GamesListNetworkEntity
import com.pedroroig.speedrunapp.domain.entity.GameModel

class GameNetworkToDomainMapper {

    fun map(netEntity: GamesListNetworkEntity) =
            netEntity.data.map {
                with(it) {
                    GameModel(id, names.international, assets.coverMedium.uri)
                }
            }
}