package com.nettour.pavesandoapp.ui.home.tour.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.nettour.pavesandoapp.R


public class VideoPaveseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_pavese)

        val webView: WebView = findViewById<WebView>(R.id.webView)

        // Configuring WebView settings
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Replace "VIDEO_ID" with the actual ID of your YouTube video
        val videoId = "uNfw-gZ6aew"
        val videoUrl = "https://www.youtube.com/embed/$videoId"

        // Load the YouTube video in the WebView
        webView.loadUrl(videoUrl)

        // Set a WebViewClient to handle errors
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                // Handle error here
            }
        }
    }
}