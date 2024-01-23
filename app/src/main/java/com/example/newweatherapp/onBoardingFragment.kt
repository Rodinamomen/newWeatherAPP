package com.example.newweatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class onBoardingFragment : Fragment() {
    lateinit var viewpagerAdapter: ViewpagerAdapter
    lateinit var viewPager: ViewPager
    lateinit var wormDotsIndicator: WormDotsIndicator
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager= view.findViewById(R.id.viewpager)
        wormDotsIndicator=view.findViewById(R.id.worm_dots_indicator)
        viewpagerAdapter = ViewpagerAdapter(requireContext())
        viewPager.adapter= viewpagerAdapter
        wormDotsIndicator.attachTo(viewPager)
    }
}