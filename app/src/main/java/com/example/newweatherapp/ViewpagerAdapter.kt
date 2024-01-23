package com.example.newweatherapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.airbnb.lottie.LottieAnimationView


class ViewpagerAdapter(val context:Context) : PagerAdapter() {
    var layoutInflater: LayoutInflater? = null
    val descriptionList = arrayOf(
        context.getString(R.string.description_1),
        context.getString(R.string.description_2),
        context.getString(R.string.description_3)
    )
    val titleList = arrayOf(
        context.getString(R.string.title_1),
        context.getString(R.string.title_2),
        context.getString(R.string.title_3)
    )
    val animationList= arrayOf(
        R.raw.start_first,
        R.raw.start_second,
        R.raw.start_third
    )
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.viewpager_custom,container,false)
        val animation = view.findViewById<LottieAnimationView>(R.id.lottieAnimationView)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val description= view.findViewById<TextView>(R.id.tv_description)
        animation.setAnimation(animationList[position])
        title.text= titleList[position]
        description.text= descriptionList[position].toString()
        container.addView(view)
        return view
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as FrameLayout)
    }
    override fun getCount(): Int {
       return descriptionList.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as FrameLayout
    }
}