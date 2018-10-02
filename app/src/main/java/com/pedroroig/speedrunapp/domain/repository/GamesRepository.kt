package com.pedroroig.speedrunapp.domain.repository

import com.pedroroig.speedrunapp.data.network.RetrofitManager
import com.pedroroig.speedrunapp.data.network.entity.GamesListNetworkEntity
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.entity.RunModel
import com.pedroroig.speedrunapp.domain.mapper.GameNetworkToDomainMapper
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GamesRepository : IGamesRepository {
    override fun findBestRun(gameId: String, observer: SingleObserver<RunModel>) {
        // TODO IMPLEMENT!!
    }

    override fun findAll(observer: SingleObserver<List<GameModel>>) {
        val retrofitManager = RetrofitManager()

        val gamesObservable = retrofitManager.getGamesListService().getAllGames()
        gamesObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<GamesListNetworkEntity> {

                    override fun onSuccess(gamesListNetworkEntity: GamesListNetworkEntity) {
                        val observable: Single<List<GameModel>> = Single.just(
                                GameNetworkToDomainMapper().map(gamesListNetworkEntity))

                        observable.subscribe(observer)
                    }

                    override fun onError(e: Throwable) {
                        observer.onError(e)
                    }

                    override fun onSubscribe(d: Disposable) {}

                })
    }

}