package com.example.youtubeapp.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.youtubeapp.R
import com.example.youtubeapp.adapters.DetailsAdapter
import com.example.youtubeapp.adapters.OnPlaylistClickListener
import com.example.youtubeapp.adapters.PlayListAdapter
import com.example.youtubeapp.models.resource_courutines.Resource
import com.example.youtubeapp.models.resource_courutines.Status
import com.example.youtubeapp.models.youtube.Item
import com.example.youtubeapp.models.youtube.PlaylistResponse
import com.example.youtubeapp.ui.playlist.PlaylistFragment
import com.example.youtubeapp.ui.playlist.PlaylistViewModel
import com.example.youtubeapp.utills.showToast
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.playlist_fragment.*

class DetailsFragment : Fragment(), OnPlaylistClickListener {


    private lateinit var viewModel: DetailsViewModel
    private lateinit var adapter: DetailsAdapter
    private lateinit var list: Item
    private var nextPageList: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            list = it.getSerializable(PlaylistFragment.PLAYLIST_KEY) as Item
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        initRecyclerAdapter()
        fetchData()
        pagination()

    }

    private fun pagination() {
        details_nested_scroll.setOnScrollChangeListener{ nested: NestedScrollView, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == nested.getChildAt(0).measuredHeight - nested.measuredHeight) {
                nextPageList?.let {
                    fetchNextList(nextPageList!!)
                }
            }
        }
    }

    private fun fetchNextList(nextPageList: String) {
        viewModel.fetchNextDetailsList(list.id, nextPageList).observe(viewLifecycleOwner, Observer {
            if (it?.data?.nextPageToken == null) {
                this.nextPageList = null
            }
            statusCheck(it)
        })
    }

    private fun fetchData() {
        viewModel.fetchDetailsListFromServer(list.id).observe(viewLifecycleOwner, Observer {
            statusCheck(it)
        })
    }

    private fun statusCheck(it: Resource<PlaylistResponse>?) {
        when(it?.status) {
            Status.SUCCESS -> setData(it)
            Status.ERROR -> context?.showToast(it.message?:"ERROR")
        }
    }

    private fun setData(it: Resource<PlaylistResponse>) {
        it.data?.items?.let {
            it1 -> adapter.add(it1)
        }
        nextPageList = it.data?.nextPageToken
    }

    private fun initRecyclerAdapter() {
        adapter = DetailsAdapter(this)
        detailsRecycler.adapter = adapter
    }


    override fun onItemClick(item: Item) {

    }

}