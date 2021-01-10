package com.example.youtubeapp.ui.playlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.youtubeapp.R
import com.example.youtubeapp.adapters.PlayListAdapter
import com.example.youtubeapp.core.MainViewModel
import kotlinx.android.synthetic.main.playlist_fragment.*

class PlaylistFragment : Fragment() {


    private lateinit var viewModel: PlaylistViewModel
    private lateinit var adapter: PlayListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.playlist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        adapter = PlayListAdapter()
        playListRecycler.adapter = adapter
        fetchData()

    }

    private fun fetchData(){
        viewModel.fetchPlaylistFromServer().observe(viewLifecycleOwner, Observer {
            Log.e("TAG", it?.nextPageToken.toString())
            it?.items?.let {
                it2 -> adapter.add(it2)
            }
        })
    }

}