package com.nettour.pavesandoapp.ui.home.tour.map

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.ActivityMapTourBinding

class MapTourActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMapTourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMapTourBinding.inflate(layoutInflater)
        val view = _binding.root

        //remove the title bar from the window
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(view)

        //set programmatically the height and width to MATCH PARENT so the pop up is larger
        window.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )

        _binding.foundationButton.setOnClickListener {
            _binding.foundationButton.text = "Tu sei qui"
            _binding.paveseHouseButton.text = "Casa di Pavese"
            _binding.walkButton.text = "Passegiata su bosco"
            //Navigate to book Tour

        }

        _binding.paveseHouseButton.setOnClickListener {
            _binding.paveseHouseButton.text = "Tu sei qui"
            _binding.foundationButton.text = "Museo Pavese"
            _binding.walkButton.text = "Passegiata su bosco"
            //Navigate to Detail page of Pavese's House

        }

        _binding.walkButton.setOnClickListener {
            _binding.walkButton.text = "Tu sei qui"
            _binding.foundationButton.text = "Museo Pavese"
            _binding.paveseHouseButton.text = "Casa di Pavese"
            //Navigate to the details of the walk

        }



    }
}