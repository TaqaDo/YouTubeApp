package com.example.youtubeapp.ui.playlist

import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.youtubeapp.R
import com.example.youtubeapp.adapters.OnPlaylistClickListener
import com.example.youtubeapp.adapters.PlayListAdapter
import com.example.youtubeapp.core.MainViewModel
import com.example.youtubeapp.models.resource_courutines.Resource
import com.example.youtubeapp.models.resource_courutines.Status
import com.example.youtubeapp.models.youtube.Item
import com.example.youtubeapp.models.youtube.PlaylistResponse
import com.example.youtubeapp.ui.playlist.PlaylistFragment.Companion.PLAYLIST_KEY
import com.example.youtubeapp.utills.showToast
import kotlinx.android.synthetic.main.playlist_fragment.*

class PlaylistFragment : Fragment(), OnPlaylistClickListener {
    companion object {
        const val PLAYLIST_KEY = "1"
    }
    private lateinit var viewModel: PlaylistViewModel
    private lateinit var adapter: PlayListAdapter
    private var nextPageList: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.playlist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        initRecyclerAdapter()
        fetchData()
        pagination()

    }

    private fun pagination() {
        playlist_nested_scroll.setOnScrollChangeListener{ nested: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == nested.getChildAt(0).measuredHeight - nested.measuredHeight) {
                nextPageList?.let {
                    fetchNextList(nextPageList!!)
                }
            }
        }
    }

    private fun fetchNextList(nextPageList: String) {
        viewModel.fetchNextPlaylist(nextPageList).observe(viewLifecycleOwner, Observer {
            if (it?.data?.nextPageToken == null) {
                this.nextPageList = null
            }
            statusCheck(it)
        })
    }

    private fun initRecyclerAdapter() {
        adapter = PlayListAdapter(this)
        playListRecycler.adapter = adapter
    }

    private fun fetchData(){
        viewModel.fetchPlaylistFromServer().observe(viewLifecycleOwner, Observer {
            statusCheck(it)
        })
    }

    private fun statusCheck(it: Resource<PlaylistResponse>?) {
        when(it?.status){
            Status.SUCCESS -> setData(it)
            Status.ERROR -> context?.showToast(it.message?: "ERROR")
        }
    }

    private fun setData(it: Resource<PlaylistResponse>) {
        it.data?.items?.let { it1 -> adapter.add(it1)  }
        nextPageList = it.data?.nextPageToken
    }

    override fun onItemClick(item: Item) {
        val bundle = Bundle()
        bundle.putSerializable(PLAYLIST_KEY, item)
        findNavController().navigate(R.id.action_playlistFragment_to_detailsFragment, bundle)
    }
}
