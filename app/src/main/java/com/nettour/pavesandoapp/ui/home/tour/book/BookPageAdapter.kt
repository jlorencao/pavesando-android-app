package com.nettour.pavesandoapp.ui.home.tour.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.nettour.pavesandoapp.R

class BookPageAdapter(private val numPages: Int): PagerAdapter() {

    private val layoutsArray = intArrayOf(
        R.layout.layout_chapter_one_left_page,
        R.layout.layout_chapter_one_right_page,
        // Add more layout resource IDs for additional pages
    )

    override fun getCount(): Int {
        return numPages
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(container.context)
        val layoutId = getLayoutResId(position)
        val pageView: View = layoutInflater.inflate(layoutId, container, false)
        container.addView(pageView)
        return pageView
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    private fun getLayoutResId(position: Int): Int {
        return if (position < layoutsArray.size) {
            layoutsArray[position]
        } else {
            // Return a default layout resource ID or handle out-of-bounds positions
            R.layout.layout_chapter_one_left_page
        }
    }
}