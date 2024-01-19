package com.nettour.pavesandoapp.ui.home.tour.map

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.nettour.pavesandoapp.R

class NutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuto)

        val videoButton = findViewById<Button>(R.id.videoButton)
        val backButton = findViewById<ImageButton>(R.id.backButton)


        videoButton.setOnClickListener {
            val intent = Intent(this, VideoNutoActivity::class.java)
            startActivity(intent)
        }
        backButton.setOnClickListener {
            finish()
        }
    }
}