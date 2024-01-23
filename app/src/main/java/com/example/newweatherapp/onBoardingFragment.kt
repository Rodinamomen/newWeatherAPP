package com.example.newweatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager


class onBoardingFragment : Fragment() {
    lateinit var viewpagerAdapter: ViewpagerAdapter
    lateinit var viewPager: ViewPager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager= view.findViewById(R.id.viewpager)
        viewpagerAdapter = ViewpagerAdapter(requireContext())
        viewPager.adapter= viewpagerAdapter
    }
}