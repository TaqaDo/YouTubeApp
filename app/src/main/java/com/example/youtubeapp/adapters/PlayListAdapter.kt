package com.example.youtubeapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapp.R
import kotlinx.android.synthetic.main.splash_holder.view.*

class PlayListAdapter (var list: List<PlayListInfo>): RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.splash_holder, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = list.get(position)
        holder.imageView.setImageResource(R.drawable.ic_cat_background)
        holder.title.text = video.title
        holder.views.text = video.views
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