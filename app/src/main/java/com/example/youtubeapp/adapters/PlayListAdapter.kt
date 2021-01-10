package com.example.youtubeapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapp.R
import com.example.youtubeapp.models.youtube.Item
import com.example.youtubeapp.models.youtube.PlaylistResponse
import kotlinx.android.synthetic.main.splash_holder.view.*
import java.security.AccessController.getContext

class PlayListAdapter: RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    var list = ArrayList<Item>()

    fun add(data: List<Item>) {
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.splash_holder, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = list.get(position).snippet
        holder.apply {
            title.text = data.title
            views.text = (list.get(position).contentDetails.itemCount.toString() + " video series")
            Glide.with(itemView.context).load(data.thumbnails.medium.url).into(imageView)
        }

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