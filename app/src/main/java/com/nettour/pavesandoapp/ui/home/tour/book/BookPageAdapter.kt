package com.nettour.pavesandoapp.ui.home.tour.book

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nettour.pavesandoapp.R
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterOneFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterThreeFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.ChapterTwoFragment
import com.nettour.pavesandoapp.ui.home.tour.book.content.QuoteBetweenPagesFragment
import com.nettour.pavesandoapp.ui.home.tour.book.welcome.WelcomeFragment

class BookPageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    private val quotes = listOf(
        fa.getString(R.string.quote_staircase),
        fa.getString(R.string.quote_before_chapter_one),
        fa.getString(R.string.quote_before_chapter_two),
        fa.getString(R.string.quote_before_chapter_three)
    )


    private val fragments = listOf(
         WelcomeFragment(),
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
           1 -> {
                val quoteText = quotes[0]
                val image = R.drawable.stairs_image1
                QuoteBetweenPagesFragment.newInstance(quoteText, image)
            }
           2 -> {
               val quoteText = quotes[1]
               val image = R.drawable.fisrt_quote_image
               QuoteBetweenPagesFragment.newInstance(quoteText, image)
           }
           4 -> {
               val quoteText = quotes[2]
               val image = R.drawable.second_quote_image
               QuoteBetweenPagesFragment.newInstance(quoteText, image)
           }
           6 -> {
               val quoteText = quotes[3]
               val image = R.drawable.third_quote_image
               QuoteBetweenPagesFragment.newInstance(quoteText, image)
           }
            else -> fragments[position]
        }

    }

}