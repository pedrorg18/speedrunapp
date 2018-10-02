package com.pedroroig.speedrunapp.domain.repository

import com.pedroroig.speedrunapp.data.network.RetrofitManager
import com.pedroroig.speedrunapp.data.network.entity.GameRunListNetworkEntity
import com.pedroroig.speedrunapp.data.network.entity.GamesListNetworkEntity
import com.pedroroig.speedrunapp.data.network.entity.UserNetworkEntity
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.entity.RunModel
import com.pedroroig.speedrunapp.domain.entity.UserModel
import com.pedroroig.speedrunapp.domain.mapper.GameNetworkToDomainMapper
import com.pedroroig.speedrunapp.domain.mapper.RunNetworkToDomainMapper
import com.pedroroig.speedrunapp.domain.mapper.UserNetworkToDomainMapper
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GamesRepository : IGamesRepository {

    override fun findAll(observer: SingleObserver<List<GameModel>>) {
        val retrofitManager = RetrofitManager()

        val gamesObservable = retrofitManager.getGamesService().getAllGames()
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

    override fun findBestRun(gameId: String, observer: SingleObserver<RunModel>) {
        val retrofitManager = RetrofitManager()

        val runObservable = retrofitManager.getGamesService()
                .getRunList(gameId)
        runObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<GameRunListNetworkEntity> {

                    override fun onSuccess(runNetworkEntity: GameRunListNetworkEntity) {
                        val runModel = RunNetworkToDomainMapper().map(runNetworkEntity)

                        // Retrieve user name by id
                        val userId = runNetworkEntity.data.first().players.first().id
                        if(userId != null) {
                            findUserName(userId,
                                    object : SingleObserver<UserModel> {

                                        override fun onSuccess(gameList: UserModel) {
                                            val observable: Single<RunModel> = Single.just(runModel)
                                            observable.subscribe(observer)
                                        }

                                        override fun onSubscribe(d: Disposable) {}

                                        override fun onError(e: Throwable) {
                                            observer.onError(e)
                                        }
                                    })
                        } else {
                            runModel.userName = "user"
                            val observable: Single<RunModel> = Single.just(runModel)
                            observable.subscribe(observer)
                        }

                    }

                    override fun onError(e: Throwable) {
                        observer.onError(e)
                    }

                    override fun onSubscribe(d: Disposable) {}

                })
    }

    override fun findUserName(userId: String, observer: SingleObserver<UserModel>) {
        val retrofitManager = RetrofitManager()

        val userObservable = retrofitManager.getGamesService()
                .getUser(userId)
        userObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<UserNetworkEntity> {

                    override fun onSuccess(userNetworkEntity: UserNetworkEntity) {
                        val observable: Single<UserModel> = Single.just(
                                UserNetworkToDomainMapper().map(userNetworkEntity))
                        observable.subscribe(observer)
                    }

                    override fun onError(e: Throwable) {
                        observer.onError(e)
                    }

                    override fun onSubscribe(d: Disposable) {}

                })
    }


}