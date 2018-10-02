package com.pedroroig.speedrunapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pedroroig.speedrunapp.domain.repository.IGamesRepository
import com.pedroroig.speedrunapp.domain.repository.mock.GamesMockRepository

class GameBestRunViewModelFactory(private val gameId: String,
    private val repository: IGamesRepository = GamesMockRepository()
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = GameBestRunViewModel(gameId, repository) as T
}
