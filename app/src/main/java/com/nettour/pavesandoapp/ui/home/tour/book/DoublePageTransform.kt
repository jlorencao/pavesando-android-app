package com.nettour.pavesandoapp.ui.home.tour.book

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class DoublePageTransform(private val numPages: Int): ViewPager.PageTransformer {

        override fun transformPage(page: View, position: Float) {
            val width = page.width.toFloat()
            val height = page.height.toFloat()

            // Ensure the page is visible
            page.alpha = 1f

            if (position < -1 || position > 1) {
                // Page is off-screen to the left or right
                page.alpha = 0f
            } else {
                // Calculate the rotation angle
                val rotation = 30 * position

                if (position <= 0) {
                    // Page is moving from left to center or is at the center
                    page.pivotX = width
                    page.pivotY = height
                } else if (position <= 1) {
                    // Page is moving from center to right or is at the center
                    page.pivotX = 0f
                    page.pivotY = height
                }

                // Set rotation, translation, and scale
                page.rotation = rotation
                page.translationX = -position * width
                page.scaleX = 1 - abs(position) * 0.2f
                page.scaleY = 1 - abs(position) * 0.2f
            }
        }
}