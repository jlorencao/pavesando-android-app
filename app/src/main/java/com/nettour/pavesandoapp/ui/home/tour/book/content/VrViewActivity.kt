package com.nettour.pavesandoapp.ui.home.tour.book.content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.nettour.pavesandoapp.R

class VrViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vr_view)

        val webView = findViewById<WebView>(R.id.roomWebView)

        // Configuring WebView settings
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        val videoId = intent.getStringExtra("videoId")
        val videoUrl = "https://www.youtube.com/embed/$videoId"

        // Loading the video
        webView.loadUrl(videoUrl)

        }

}
