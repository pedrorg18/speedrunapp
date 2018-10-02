package com.pedroroig.speedrunapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pedroroig.speedrunapp.data.repository.IGamesRepository
import com.pedroroig.speedrunapp.domain.entity.GameModel

class MainViewModel(repo: IGamesRepository): ViewModel() {

    private val games = MutableLiveData<List<GameModel>>()

    init {
        games.value = repo.findAll()
    }

    fun getGames() = games

}