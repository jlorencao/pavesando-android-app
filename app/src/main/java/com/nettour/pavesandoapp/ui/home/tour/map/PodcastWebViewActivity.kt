package com.nettour.pavesandoapp.ui.home.tour.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.databinding.ActivityPodcastWebViewBinding

class PodcastWebViewActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityPodcastWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityPodcastWebViewBinding.inflate(layoutInflater)
        val view = _binding.root

        _binding.podcastWebView.loadUrl("https://open.spotify.com/episode/0pFNTZJG086yo07YgucqsC?si=4Q-AtnGiQq6Ep-LNkfkp5g")

        setContentView(view)
    }
}