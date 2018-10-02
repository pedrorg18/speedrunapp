package com.pedroroig.speedrunapp.domain.mapper

import com.pedroroig.speedrunapp.data.network.entity.GameRunListNetworkEntity
import com.pedroroig.speedrunapp.data.network.entity.Player
import com.pedroroig.speedrunapp.domain.entity.RunModel

class RunNetworkToDomainMapper {

    fun map(netEntity: GameRunListNetworkEntity) =
            with(netEntity.data.first()) {
                RunModel(videos.links.first().uri,
                        getPlayerName(players.first()),
                        times.primary_t
                )
            }

    private fun getPlayerName(player: Player): String {
        with(player) {
            if(name != null) {
                return name
            }
            if(id != null) {
                return id
            }
            return "user"
        }
    }
}