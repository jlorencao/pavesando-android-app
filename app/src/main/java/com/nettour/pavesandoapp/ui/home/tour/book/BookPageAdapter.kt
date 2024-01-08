package com.nettour.pavesandoapp.ui.home.tour.book

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterOneFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterThreeFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterTwoFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.QuoteBetweenPagesFragment

class BookPageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    private val quotes = listOf(
        fa.getString(R.string.quote_staircase),
        fa.getString(R.string.quote_before_chapter_one),
        fa.getString(R.string.quote_before_chapter_two),
        fa.getString(R.string.quote_before_chapter_three)
    )


    private val fragments = listOf(
         QuoteBetweenPagesFragment(),
         QuoteBetweenPagesFragment(),
         ChapterOneFragment(),
         QuoteBetweenPagesFragment(),
         ChapterTwoFragment(),
         QuoteBetweenPagesFragment(),
         ChapterThreeFragment(),
     )

    override fun getItemCount(): Int {

        return fragments.size
    }


    override fun createFragment(position: Int): Fragment {
       return when (position) {
           0 -> {
                val quoteText = quotes[0]
                QuoteBetweenPagesFragment.newInstance(quoteText)
            }
           1 -> {
               val quoteText = quotes[1]
               QuoteBetweenPagesFragment.newInstance(quoteText)
           }
           3 -> {
               val quoteText = quotes[2]
               QuoteBetweenPagesFragment.newInstance(quoteText)
           }
           5 -> {
               val quoteText = quotes[3]
               QuoteBetweenPagesFragment.newInstance(quoteText)
           }
            else -> fragments[position]
        }

    }

}