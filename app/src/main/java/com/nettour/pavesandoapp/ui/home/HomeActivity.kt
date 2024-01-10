package com.nettour.pavesandoapp.ui.home

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.ActivityHomeBinding
import com.nettour.pavesandoapp.ui.home.tour.book.MuseumTourActivity
import com.nettour.pavesandoapp.ui.home.tour.map.MapTourActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = _binding.root

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        setContentView(view)

        _binding.museumTourButton.setOnClickListener {
            //navigate to book tour
            val intent = Intent(this, MuseumTourActivity::class.java)
            intent.putExtra("fragment","BookFragment")
            startActivity(intent)
        }

        _binding.mapsTourButton.setOnClickListener {
            //navigate to map tour
            val intent = Intent(this, MuseumTourActivity::class.java)
            intent.putExtra("fragment", "MapTourFragment" )
            startActivity(intent)
        }
    }
}