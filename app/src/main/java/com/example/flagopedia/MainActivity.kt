package com.example.flagopedia

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var act_1 : Button
    lateinit var act_2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        act_1 = findViewById(R.id.act_1)
        act_2 = findViewById(R.id.act_2)

        // Add scaling animation to Activity 1 button
        act_1.setOnTouchListener { v, event ->
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

        // Activity 1 button click
        act_1.setOnClickListener {
            val intent = Intent(this, Activity1::class.java) // Replace with your Activity1 class
            startActivity(intent)
        }

        act_2.setOnTouchListener { v, event ->
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

        act_2.setOnClickListener {
            val intent = Intent(this, CountryList::class.java)
            startActivity(intent)
        }
    }
}

