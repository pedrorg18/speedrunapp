package com.pedroroig.speedrunapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pedroroig.speedrunapp.ui.adapters.GameListAdapter
import com.pedroroig.speedrunapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager
import com.pedroroig.speedrunapp.Logger
import com.pedroroig.speedrunapp.R
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.extensions.toast
import com.pedroroig.speedrunapp.viewmodel.GameListViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var viewAdapter: GameListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Speed Run List"

        initRecyclerView()

        initViewModel()
    }

    private fun initRecyclerView() {
        viewAdapter = GameListAdapter(null)
        val layoutManager = LinearLayoutManager(this)
        rvGameList.layoutManager = layoutManager
        rvGameList.adapter = viewAdapter
    }

    private fun initViewModel() {
        val factory = GameListViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        // If new data arrives, update view
        viewModel.getGames().observe(this, Observer { games ->
            updateUi(games)
        })
        viewModel.getError().observe(this, Observer { msg ->
            toast("Error: $msg")
        })
    }

    private fun updateUi(games: List<GameModel>?) {
        Logger.i("games: $games")
        viewAdapter.setDataSet(games)
        viewAdapter.notifyDataSetChanged()
    }

}
