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
        countryList.add(DataClass(R.drawable.ph, "Philippines", R.drawable.rect_1, "Manila"))
        countryList.add(DataClass(R.drawable.germany, "Germany", R.drawable.rect_2, "Berlin"))
        countryList.add(DataClass(R.drawable.brazil, "Brazil", R.drawable.rect_1, "Brasilia"))
        countryList.add(DataClass(R.drawable.ph, "Philippines", R.drawable.rect_1, "Manila"))
        countryList.add(DataClass(R.drawable.australia, "Australia", R.drawable.rect_2, "Canberra"))
        countryList.add(DataClass(R.drawable.canada, "Canada", R.drawable.rect_1, "Ottawa"))
        countryList.add(DataClass(R.drawable.china, "China", R.drawable.rect_2, "Beijing"))
        countryList.add(DataClass(R.drawable.egypt, "Egypt", R.drawable.rect_1, "Cairo"))
        countryList.add(DataClass(R.drawable.finland, "Finland", R.drawable.rect_2, "Helsinki"))
        countryList.add(DataClass(R.drawable.france, "France", R.drawable.rect_1, "Paris"))
        countryList.add(DataClass(R.drawable.india, "India", R.drawable.rect_2, "New Delhi"))
        countryList.add(DataClass(R.drawable.indonesia, "Indonesia", R.drawable.rect_1, "Jakarta"))
        countryList.add(DataClass(R.drawable.italy, "Italy", R.drawable.rect_2, "Rome"))
        countryList.add(DataClass(R.drawable.japan, "Japan", R.drawable.rect_1, "Tokyo"))
        countryList.add(DataClass(R.drawable.mexico, "Mexico", R.drawable.rect_2, "Mexico City"))
        countryList.add(DataClass(R.drawable.norway, "Norway", R.drawable.rect_1, "Oslo"))
        countryList.add(DataClass(R.drawable.russia, "Russia", R.drawable.rect_2, "Moscow"))
        countryList.add(DataClass(R.drawable.saudi_arabia, "Saudi Arabia", R.drawable.rect_1, "Riyadh"))
        countryList.add(DataClass(R.drawable.south_africa, "South Africa", R.drawable.rect_2, "Pretoria"))
        countryList.add(DataClass(R.drawable.south_korea, "South Korea", R.drawable.rect_1, "Seoul"))
        countryList.add(DataClass(R.drawable.us, "USA", R.drawable.rect_2, "Washington, D.C."))
        countryList.add(DataClass(R.drawable.yemen, "Yemen", R.drawable.rect_1, "Sana'a"))



        AdapterClass = AdapterClass(countryList, this)

        // Set layout animation
        val layoutAnimation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fade_in)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterClass
        recyclerView.layoutAnimation = layoutAnimation
    }

}

