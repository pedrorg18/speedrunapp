package com.pedroroig.speedrunapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.pedroroig.speedrunapp.Logger
import com.pedroroig.speedrunapp.R
import com.pedroroig.speedrunapp.extensions.ctx
import com.pedroroig.speedrunapp.extensions.toast
import com.pedroroig.speedrunapp.domain.entity.GameModel
import com.pedroroig.speedrunapp.ui.glide.GlideApp

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
            GlideApp.with(viewRoot.ctx)
                    .load(dataSet?.get(position)?.imageLocation)
                    .placeholder(R.drawable.default_image)
                    .into(image)

            viewRoot.setOnClickListener {
                viewRoot.ctx.toast("click element ${dataSet!![position].id}")
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