package com.example.flagopedia

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class trylng : AppCompatActivity() {

    lateinit var AdapterClass : AdapterClass
    lateinit var DataClass : ArrayList<DataClass>
    lateinit var countryList: ArrayList<DataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trylng)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        countryList = ArrayList()

        countryList.add(DataClass(R.drawable.ph, "Philippines", R.drawable.country_bg1))
        countryList.add(DataClass(R.drawable.german, "German", R.drawable.country_bg2))

        AdapterClass = AdapterClass(countryList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterClass


    }
}