package com.example.oros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This Button will navigate to the second screen after the user clicked
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {

            val intent = Intent(this, SecondScreen::class.java)

            // This will pass the message "I am hungry" as an extra with the intent
            intent.putExtra(
                "FEED_MESSAGE",
                "I am hungry"
            ) // This will be displayed in the feedTextView
            startActivity(intent)
        }
    }
}