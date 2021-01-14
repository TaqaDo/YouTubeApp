package com.example.youtubeapp.ui.saved_videos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.youtubeapp.R
import com.example.youtubeapp.adapters.DetailsAdapter
import com.example.youtubeapp.adapters.OnPlaylistClickListener
import com.example.youtubeapp.models.youtube.Item
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.saved_fragment.*


class SavedFragment : Fragment(), OnPlaylistClickListener {


    private lateinit var viewModel: SavedViewModel
    private lateinit var adapter: DetailsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.saved_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SavedViewModel::class.java)
        viewModel.initRepository(requireContext())
        initRecyclerAdapter()
        fetchData()
//        remorePreviouseFragmnetFromBackStack()

    }

//    private fun remorePreviouseFragmnetFromBackStack() {
//        findNavController().popBackStack(R.id.connectionFragment, true)
//
//    }

    private fun fetchData() {
        viewModel.getDetailsFromDB()
        viewModel.localData.observe(viewLifecycleOwner, Observer {
            adapter.add(it)
        })
    }

    private fun initRecyclerAdapter() {
        adapter = DetailsAdapter(this)
        savedRecycler.adapter = adapter
    }

    override fun onItemClick(item: Item) {

    }


}