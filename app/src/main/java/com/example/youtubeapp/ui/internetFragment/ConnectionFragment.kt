package com.example.youtubeapp.ui.internetFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.youtubeapp.R
import com.example.youtubeapp.utills.NetworkConnection
import kotlinx.android.synthetic.main.connection_fragment.*

class ConnectionFragment : Fragment() {

    private lateinit var viewModel: ConnectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.connection_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ConnectionViewModel::class.java)

        goToSavedVideos()


    }

    private fun goToSavedVideos() {
        btn_saved_videos.setOnClickListener {
            findNavController().navigate(R.id.action_connectionFragment_to_savedFragment2)
        }
    }



}