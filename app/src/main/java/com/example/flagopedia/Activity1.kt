import com.example.flagopedia.R

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class Activity1 : AppCompatActivity() {

    private lateinit var backButton: ImageButton
    private lateinit var countryNames: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1)

        // Initialize the views
        backButton = findViewById(R.id.backButton)

        // List of country TextViews
        countryNames = listOf(
            findViewById(R.id.name1),
            findViewById(R.id.name2),
            findViewById(R.id.name3),
            findViewById(R.id.name4),
            findViewById(R.id.name5),
            findViewById(R.id.name6),
            findViewById(R.id.name7),
            findViewById(R.id.name8),
            findViewById(R.id.name9),
            findViewById(R.id.name10),
            findViewById(R.id.name11),
            findViewById(R.id.name12),
            findViewById(R.id.name13),
            findViewById(R.id.name14),
            findViewById(R.id.name15),
            findViewById(R.id.name16),
            findViewById(R.id.name17),
            findViewById(R.id.name18),
            findViewById(R.id.name19),
            findViewById(R.id.name20)
        )

        // Set up back button click listener
        backButton.setOnClickListener {
            finish()  // Close the activity or navigate back to previous screen
        }

    }


}
