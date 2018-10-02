package com.pedroroig.speedrunapp.domain.mapper

import com.pedroroig.speedrunapp.data.network.entity.UserNetworkEntity
import com.pedroroig.speedrunapp.domain.entity.UserModel

class UserNetworkToDomainMapper {

    fun map(netEntity: UserNetworkEntity) =
            with(netEntity.data) {
                UserModel(names.international
                )
            }
}