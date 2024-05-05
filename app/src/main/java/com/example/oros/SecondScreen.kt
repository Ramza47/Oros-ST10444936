package com.example.oros

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondScreen : AppCompatActivity() {

    private lateinit var feedProgressBar: ProgressBar
    private lateinit var playProgressBar: ProgressBar
    private lateinit var cleanProgressBar: ProgressBar

    private var feedProgressStatus: Int = 0
    private var playProgressStatus: Int = 0
    private var cleanProgressStatus: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)


        val petImageView = findViewById<ImageView>(R.id.imageView2)
        val feedButton = findViewById<Button>(R.id.feedButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val playButton = findViewById<Button>(R.id.playButton)

        val feedTextView = findViewById<TextView>(R.id.feedTextView)
        val cleanTextView = findViewById<TextView>(R.id.cleanTextView)
        val playTextView = findViewById<TextView>(R.id.playTextView)

        feedProgressBar = findViewById(R.id.feedprogressBar)
        cleanProgressBar = findViewById(R.id.cleanprogressBar)
        playProgressBar = findViewById(R.id.playprogressBar)

        // This Retrieves the message passed from the first screen
        val feedMessage = intent.getStringExtra("FEED_MESSAGE")

        // This sets the text of the feed TextView to the feed message
        feedTextView.text = feedMessage

        // Logic for the Feed button
        feedButton.setOnClickListener {

            // Changes the pet`s image to mach feed action icon
            petImageView.setImageResource(R.drawable.eating)

            // Updates the pet`s status such as hunger and also updates the feed TextView
            feedTextView.text = getString(R.string.feed)

            // Updates the play TextView
            playTextView.text = getString(R.string.Play)


            // Logic for the Clean Button
            cleanButton.setOnClickListener {

                //changes the pet`s image to match cleaning action icon
                petImageView.setImageResource(R.drawable.bathing)

                // Updates the the pet`s status such as cleanliness and the clean textview
                cleanTextView.text = getString(R.string.clean)


                // Logic for the pay button
                playButton.setOnClickListener {

                    // changes the pet`s image to match the playing action icon
                    petImageView.setImageResource(R.drawable.playing)

                    // Updates the pet`s status such as happiness and updates the play textview
                    playTextView.text = getString(R.string.play)

                    // updates the clean textview
                    cleanTextView.text = getString(R.string.clean)


                    feedButton.setOnClickListener {
                        feedProgressStatus = 0
                        feedProgressBar.progress = feedProgressStatus
                        Thread(Runnable {
                            while (feedProgressStatus < 100) {
                                feedProgressBar
                                Thread.sleep(1000)
                                runOnUiThread {
                                    feedProgressBar.progress = feedProgressStatus
                                }
                            }
                            runOnUiThread {
                                // Updates feedTextView message
                            }
                        }).start()
                    }


                    cleanButton.setOnClickListener {
                        cleanProgressStatus = 0
                        cleanProgressBar.progress = cleanProgressStatus
                        Thread(Runnable {
                            while (cleanProgressStatus < 100) {
                                cleanProgressStatus += 5
                                Thread.sleep(1000)
                                runOnUiThread {
                                    cleanProgressBar.progress =
                                        cleanProgressStatus
                                }
                            }
                            runOnUiThread {
                                // Updates the cleanTextView message
                            }
                        }).start()
                    }

                    playButton.setOnClickListener {
                        playProgressStatus =
                            0
                        playProgressBar.progress =
                            playProgressStatus

                        Thread(Runnable {
                            while (playProgressStatus < 100) {
                                playProgressStatus += 5
                                Thread.sleep(
                                    1000
                                )

                                runOnUiThread {
                                    playProgressBar.progress =
                                        playProgressStatus
                                }
                            }
                            runOnUiThread {
                                // Update playTextView message
                            }
                        }).start()
                    }
                }
            }
        }
    }
}
