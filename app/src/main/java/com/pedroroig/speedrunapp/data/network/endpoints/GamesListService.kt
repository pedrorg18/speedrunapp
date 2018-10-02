package com.pedroroig.speedrunapp.data.network.endpoints

import com.pedroroig.speedrunapp.data.network.entity.GamesListNetworkEntity
import io.reactivex.Single
import retrofit2.http.GET

interface GamesListService {

    @GET("games")
    fun getAllGames(): Single<GamesListNetworkEntity>

}