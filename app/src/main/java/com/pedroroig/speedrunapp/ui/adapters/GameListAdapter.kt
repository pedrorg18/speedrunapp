package com.pedroroig.speedrunapp.ui.adapters

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pedroroig.speedrunapp.Logger
import com.pedroroig.speedrunapp.R
import com.pedroroig.speedrunapp.extensions.ctx
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.ui.EXTRA_GAME_ENTITY
import com.pedroroig.speedrunapp.ui.GameBestRunActivity
import com.pedroroig.speedrunapp.ui.glide.showImage

class GameListAdapter(private var dataSet: List<GameModel>?): RecyclerView.Adapter<GameListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewRoot: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewRoot.context)
                .inflate(R.layout.list_row_item, viewRoot, false))
    }

    override fun getItemCount() = dataSet?.size ?: 0

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        Logger.i("onBindViewHolder: $vh position: $position")
        with(vh) {
            name.text = dataSet?.get(position)?.name ?: ""
            showImage(dataSet?.get(position)?.imageLocation, image)

            viewRoot.setOnClickListener {
                val intent = Intent(viewRoot.ctx, GameBestRunActivity::class.java)
                intent.putExtra(EXTRA_GAME_ENTITY, dataSet?.get(position))
                viewRoot.ctx.startActivity(intent)
            }
        }
    }

    fun setDataSet(ds: List<GameModel>?) {
        dataSet = ds
    }

    class ViewHolder(val viewRoot: View) :
            RecyclerView.ViewHolder(viewRoot) {
        val name: TextView = viewRoot.findViewById(R.id.listElementName)
        val image: ImageView = viewRoot.findViewById(R.id.listElementLogo)
    }
}