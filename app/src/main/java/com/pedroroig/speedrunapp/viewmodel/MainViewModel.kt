package com.pedroroig.speedrunapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pedroroig.speedrunapp.data.repository.GamesRepository
import com.pedroroig.speedrunapp.model.entity.GameModel

class MainViewModel(private val repo: GamesRepository): ViewModel() {

    private val games = MutableLiveData<List<GameModel>>()

    init {
        games.value = repo.findAll()
    }

    fun getGames() = games

}