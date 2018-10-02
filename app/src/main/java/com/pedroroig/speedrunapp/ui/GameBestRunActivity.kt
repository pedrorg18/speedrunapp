package com.pedroroig.speedrunapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pedroroig.speedrunapp.Logger
import com.pedroroig.speedrunapp.R
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.domain.entity.RunModel
import com.pedroroig.speedrunapp.extensions.toast
import com.pedroroig.speedrunapp.ui.glide.showImage
import com.pedroroig.speedrunapp.viewmodel.GameBestRunViewModel
import com.pedroroig.speedrunapp.viewmodel.GameBestRunViewModelFactory
import kotlinx.android.synthetic.main.activity_game_best_run.*
import android.content.Intent
import android.net.Uri
import java.text.DecimalFormat


class GameBestRunActivity : AppCompatActivity() {

    private lateinit var viewModel: GameBestRunViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_best_run)

        val gameModel: GameModel = intent.getSerializableExtra(EXTRA_GAME_ENTITY) as GameModel
        supportActionBar?.title = "Best run for ${gameModel.name}"
        showImage(gameModel.imageLocation, bestRunGameLogo)

        initViewModel(gameModel.id)
    }

    private fun initViewModel(gameId: String) {
        val factory = GameBestRunViewModelFactory(gameId)
        viewModel = ViewModelProviders.of(this, factory).get(GameBestRunViewModel::class.java)
        // If new data arrives, update view
        viewModel.getBestRun().observe(this, Observer { bestRun ->
            updateUi(bestRun)
        })
        viewModel.getError().observe(this, Observer { msg ->
            toast("Error: $msg")
        })
    }

    private fun updateUi(run: RunModel?) {
        Logger.i("run: $run")
        textViewUserName.text = run?.userName ?: ""
        textViewBestTime.text = formatTime(run?.bestTime)
        loadVideoButton.setOnClickListener {
            loadVideo(run?.videoLocation)
        }
    }

    private fun formatTime(bestTime: Float?): String {
        if(bestTime != null) {
            val format = DecimalFormat("0.#")
            return format.format(bestTime)
        }
        return ""
    }

    private fun loadVideo(videoLocation: String?) {
        if(videoLocation != null) {
            val webIntent = Intent(Intent.ACTION_VIEW,
                    Uri.parse(videoLocation))
            startActivity(webIntent)
        } else {
            toast("Error loading video")
        }
    }

}
