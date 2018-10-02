package com.pedroroig.speedrunapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pedroroig.speedrunapp.domain.repository.IGamesRepository
import com.pedroroig.speedrunapp.domain.entity.GameModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainViewModel(repo: IGamesRepository): ViewModel() {

    private val games = MutableLiveData<List<GameModel>>()
    private val errorMsg = MutableLiveData<String>()

    init {
         repo.findAll(object: SingleObserver<List<GameModel>> {
             override fun onSuccess(gameList: List<GameModel>) {
                 games.value = gameList
             }

             override fun onSubscribe(d: Disposable) {}

             override fun onError(e: Throwable) {
                 errorMsg.value = e.message
             }
         })
    }

    fun getGames() = games

    fun getError() = errorMsg

}