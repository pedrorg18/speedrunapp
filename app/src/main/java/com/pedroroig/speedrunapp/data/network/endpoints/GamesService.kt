package com.pedroroig.speedrunapp.data.network.endpoints

import com.pedroroig.speedrunapp.data.network.entity.GameRunListNetworkEntity
import com.pedroroig.speedrunapp.data.network.entity.GamesListNetworkEntity
import com.pedroroig.speedrunapp.data.network.entity.UserNetworkEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesService {

    @GET("games")
    fun getAllGames(): Single<GamesListNetworkEntity>

    @GET("runs")
    fun getRunList(@Query("game") game: String ): Single<GameRunListNetworkEntity>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: String ): Single<UserNetworkEntity>

}