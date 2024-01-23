package com.example.newweatherapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlin.math.log

private var progress = 33
private var currentPage = 0
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
        viewPager= view.findViewById(R.id.viewpager)
        progressBar= view.findViewById(R.id.progressBar)
        nextButton= view.findViewById(R.id.fb_next)
        nextButton.setOnClickListener {
            if(currentPage==0){
                currentPage=1
                viewPager.setCurrentItem(currentPage)
                progress = 33
                progressBar.progress = progress
            }
            else if (currentPage==1) {
                currentPage=2
                viewPager.setCurrentItem(currentPage)
                progress = 67
                progressBar.progress = progress
            }
            else if(currentPage==2){
                progress=100
                progressBar.progress= progress
            }
        }
        wormDotsIndicator=view.findViewById(R.id.worm_dots_indicator)
        viewpagerAdapter = ViewpagerAdapter(requireContext())
        viewPager.adapter= viewpagerAdapter
        wormDotsIndicator.attachTo(viewPager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (position == 0) {
                    currentPage=0
                    progress = 33
                    progressBar.progress = progress
                }
                if (position == 1) {
                    currentPage=1
                    progress = 67
                    progressBar.progress = progress
                }
                if (position == 2) {
                    currentPage=2
                    progress = 100
                    progressBar.progress = progress
                }
            }
            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }
}


