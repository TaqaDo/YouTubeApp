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

class PlayListAdapter(var onClickListener: OnPlaylistClickListener)
    : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

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

        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(list[position])
        }

    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView) {

        fun onBind(item: Item) {
            itemView.apply {
                tvTitle.text = item.snippet?.title
                tvAmountViews.text = (item.contentDetails?.itemCount.toString() + " video series")
                Glide.with(this).load(item.snippet?.thumbnails?.medium?.url).into(ivVideo)
            }
        }

    }

}