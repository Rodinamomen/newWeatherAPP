package com.example.newweatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator


class onBoardingFragment : Fragment() {
    lateinit var viewpagerAdapter: ViewpagerAdapter
    lateinit var viewPager: ViewPager
    lateinit var wormDotsIndicator: WormDotsIndicator
    lateinit var nextButton : FloatingActionButton
    lateinit var progressBar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var progress = 33
        viewPager= view.findViewById(R.id.viewpager)
        progressBar= view.findViewById(R.id.progressBar)
        nextButton= view.findViewById(R.id.fb_next)
        nextButton.setOnClickListener {
            if(progressBar.progress in 33..98) {
                progress=progress+34
                progressBar.progress = progress
            }else if(progressBar.progress==100){
                progress=0
                progressBar.progress=progress
            }else if (progressBar.progress==0){
                progress=33
                progressBar.progress=progress
            }
        }
        wormDotsIndicator=view.findViewById(R.id.worm_dots_indicator)
        viewpagerAdapter = ViewpagerAdapter(requireContext())
        viewPager.adapter= viewpagerAdapter
        wormDotsIndicator.attachTo(viewPager)
    }
}