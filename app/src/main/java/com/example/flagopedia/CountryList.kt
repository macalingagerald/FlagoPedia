package com.example.flagopedia

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
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
        setupClickListeners()
    }

    private fun initializeCountryViews() {
        countryViews = listOf(
            findViewById<TextView>(R.id.name1) to findViewById(R.id.capitalInfo),
            // Add more countries as needed
        )
    }

    private fun setupClickListeners() {
        val capitals = mapOf(
            R.id.name1 to "Manila",
            R.id.name2 to "Washington, D.C.",
            R.id.name3 to "Ottawa",
            R.id.name4 to "Brasília",
            R.id.name5 to "Buenos Aires"
            // Add more capitals as needed
        )

        countryViews.forEach { (countryView, capitalView) ->
            countryView.setOnClickListener {
                handleCountryClick(countryView, capitalView, capitals[countryView.id] ?: "")
            }
        }
    }

    private fun handleCountryClick(countryView: TextView, capitalView: TextView, capital: String) {
        if (expandedView == countryView) {
            collapseView(countryView, capitalView)
        } else {
            expandedView?.let { previousView ->
                expandedCapitalInfo?.let { previousCapital ->
                    collapseView(previousView, previousCapital)
                }
            }
            expandView(countryView, capitalView, capital)
        }
    }

    private fun expandView(countryView: TextView, capitalView: TextView, capital: String) {
        val expandAnim = AnimationUtils.loadAnimation(this, R.anim.expand_animation)

        capitalView.text = "Capital: $capital"
        capitalView.visibility = View.VISIBLE

        countryView.startAnimation(expandAnim)
        capitalView.startAnimation(expandAnim)

        expandedView = countryView
        expandedCapitalInfo = capitalView
    }

    private fun collapseView(countryView: TextView, capitalView: TextView) {
        val collapseAnim = AnimationUtils.loadAnimation(this, R.anim.collapse_animation)

        countryView.startAnimation(collapseAnim)
        capitalView.startAnimation(collapseAnim)

        collapseAnim.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation?) {}
            override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
            override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                capitalView.visibility = View.GONE
            }
        })

        expandedView = null
        expandedCapitalInfo = null
    }
}