package com.nettour.pavesandoapp.ui.home.tour.map

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.nettour.pavesandoapp.R

class CasaPaveseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_casa_pavese)

        val videoButton = findViewById<Button>(R.id.videoButton)
        val backButton = findViewById<ImageButton>(R.id.backButton)

        videoButton.setOnClickListener {
            val intent = Intent(this, VideoPaveseActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }


    }
}