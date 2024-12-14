package com.example.flagopedia

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CountryList : AppCompatActivity() {
    private lateinit var countryViews: List<Pair<TextView, TextView>>
    private var expandedView: TextView? = null
    private var expandedCapitalInfo: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_country_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initializeCountryViews()
        setupBackButton()
    }

    private fun initializeCountryViews() {
        countryViews = listOf(
            findViewById<TextView>(R.id.name1) to findViewById(R.id.capitalInfo),
        )
    }


    private fun setupBackButton() {
        val backButton: ImageButton = findViewById(R.id.backButton)

        backButton.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Scale down when pressed
                    v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    // Scale back to normal when released
                    v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                }
            }
            false // Return false to allow the normal onClick event to fire
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}