package com.nettour.pavesandoapp.ui.home.tour.book

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterOneFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterThreeFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterTwoFragment

class BookPageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    private val fragments = listOf(
        ChapterOneFragment(),
        ChapterTwoFragment(),
        ChapterThreeFragment()
    )

    override fun getItemCount(): Int {

        return fragments.size
    }


    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}