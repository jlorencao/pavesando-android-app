package com.nettour.pavesandoapp.ui.home

import android.content.Intent
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

        setContentView(view)

        _binding.bookTourButton.setOnClickListener {
            //navigate to book tour
            val intent = Intent(this, MuseumTourActivity::class.java)
            startActivity(intent)
        }

        _binding.mapTourButton.setOnClickListener {
            //navigate to map tour
            val intent = Intent(this, MapTourActivity::class.java)
            startActivity(intent)
        }
    }
}