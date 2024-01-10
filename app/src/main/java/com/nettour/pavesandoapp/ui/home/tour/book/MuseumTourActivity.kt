package com.nettour.pavesandoapp.ui.home.tour.book

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.ActivityMuseumTourBinding
import com.nettour.pavesandoapp.ui.home.tour.map.MapTourFragment

class MuseumTourActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMuseumTourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMuseumTourBinding.inflate(layoutInflater)
        val view = _binding.root

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(view)

        val fragmentToOpen = intent.getStringExtra("fragment")

        if(fragmentToOpen != null) {
            openFragment(fragmentToOpen)
        }
    }
    private fun openFragment(fragmentToOpen: String) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        when (fragmentToOpen){
             "BookFragment" -> {
              fragmentTransaction.replace(R.id.fragmentContainerView, BookFragment())
             }
            "MapTourFragment" -> {
                fragmentTransaction.replace(R.id.fragmentContainerView, MapTourFragment())
            }
            else -> Log.d("error","error")
        }
           fragmentTransaction.commit()
    }
}