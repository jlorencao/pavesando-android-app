package com.nettour.pavesandoapp.ui.home.tour.book

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.ActivityMuseumTourBinding
import com.nettour.pavesandoapp.ui.home.tour.book.welcome.WelcomeFirstScreenFragment
import com.nettour.pavesandoapp.ui.home.tour.map.MapTourFragment

class MuseumTourActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMuseumTourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMuseumTourBinding.inflate(layoutInflater)
        val view = _binding.root

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(view)

        supportFragmentManager
            .beginTransaction()
            .add(
                R.id.fragmentContainerView,
                MapTourFragment()
            )
            .commit()

    }
}