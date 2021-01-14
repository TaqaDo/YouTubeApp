package com.example.youtubeapp.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.youtubeapp.R
import com.example.youtubeapp.core.BaseActivity
import com.example.youtubeapp.utills.NetworkConnection
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.connection_fragment.*

class MainActivity : BaseActivity(R.layout.activity_main) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        chekNetworkConnection()

    }

    private fun chekNetworkConnection() {
        val networkConnection = NetworkConnection(applicationContext)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.youtubeNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        networkConnection.observe(this, Observer { isConnected ->
            if (isConnected) {
                navController.navigate(R.id.playlistFragment)
            } else {
                navController.navigate(R.id.connectionFragment)
            }
        })
    }


}