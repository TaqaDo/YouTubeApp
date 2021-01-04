package com.example.youtubeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapp.R
import com.example.youtubeapp.models.youtube.PlaylistResponse
import kotlinx.android.synthetic.main.splash_holder.view.*

class PlayListAdapter (var list: List<PlaylistResponse>): RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.splash_holder, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = list.get(position)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.ivVideo
        val title = itemView.tvTitle
        val views = itemView.tvAmountViews
    }

}