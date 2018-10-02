package com.pedroroig.speedrunapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pedroroig.speedrunapp.domain.repository.IGamesRepository
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.entity.RunModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class GameBestRunViewModel(gameId: String,
                           repo: IGamesRepository): ViewModel() {

    private val bestRun = MutableLiveData<RunModel>()
    private val errorMsg = MutableLiveData<String>()

    init {
         repo.findBestRun(gameId, object: SingleObserver<RunModel> {
             
             override fun onSuccess(gameList: RunModel) {
                 bestRun.value = gameList
             }

             override fun onSubscribe(d: Disposable) {}

             override fun onError(e: Throwable) {
                 errorMsg.value = e.message
             }
         })
    }

    fun getBestRun() = bestRun

    fun getError() = errorMsg


}