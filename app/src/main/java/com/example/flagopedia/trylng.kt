package com.example.flagopedia

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class trylng : AppCompatActivity() {

    lateinit var AdapterClass: AdapterClass
    lateinit var DataClass: ArrayList<DataClass>
    lateinit var countryList: ArrayList<DataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trylng)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        countryList = ArrayList()

        // Add countries with capitals
        countryList.add(DataClass(R.drawable.ph, "Philippines", R.drawable.country_bg1, "Manila"))
        countryList.add(DataClass(R.drawable.german, "Germany", R.drawable.country_bg2, "Berlin"))

        AdapterClass = AdapterClass(countryList, this)

        // Set layout animation
        val layoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fade_in)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterClass
        recyclerView.layoutAnimation = layoutAnimation
    }

}
