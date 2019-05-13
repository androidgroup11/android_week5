package com.example.myapplication

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class tabSlideAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Now_playing()
            }
            else -> {
                Top_rate()
            }

            /*else -> {
                return searchFragment()
            }*/
        }
    }

    override fun getCount(): Int { // tra ve so luong cac view co san
        //TODO:
        return 3;
        // return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Now Playing"
            1 -> "Top Rate"
            else -> {
                return "Search"
            }
        }
    }
}
