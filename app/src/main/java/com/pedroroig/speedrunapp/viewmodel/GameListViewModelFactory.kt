package com.pedroroig.speedrunapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.pedroroig.speedrunapp.data.repository.GamesRepository

class GameListViewModelFactory(
    private val repository: GamesRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = MainViewModel(repository) as T
}
