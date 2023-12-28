package com.nettour.pavesandoapp.ui.home.tour.book

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nettour.pavesandoapp.R

class MuseumTourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_museum_tour)

        supportFragmentManager
            .beginTransaction()
            .add(
                R.id.fragmentContainerView,
                BookFragment())
            .commit()

    }
}