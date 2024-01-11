package com.nettour.pavesandoapp.ui.home

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nettour.pavesandoapp.databinding.ActivityHomeBinding
import com.nettour.pavesandoapp.ui.home.tour.ChiesaActivity
import com.nettour.pavesandoapp.ui.home.tour.book.MuseumTourActivity


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

        _binding.churchTourButton.setOnClickListener {
            //navigate to ChiesaActivity
            val intent = Intent(this, ChiesaActivity::class.java)
            startActivity(intent)
        }

        _binding.penImageButton.setOnClickListener{
            //navigate to outside URL
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://fondazionecesarepavese.it/"))
            startActivity(browserIntent)

        }

        _binding.shopButton.setOnClickListener{
            //navigate to shop on outside URL
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://shop.fondazionecesarepavese.it/collections/all"))
            startActivity(browserIntent)
        }


    }
}