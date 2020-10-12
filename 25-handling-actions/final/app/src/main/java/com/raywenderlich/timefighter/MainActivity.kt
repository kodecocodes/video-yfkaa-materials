package com.raywenderlich.timefighter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  private var score = 0

  private lateinit var tapMeButton: Button
  private lateinit var gameScoreTextView: TextView
  private lateinit var timeLeftTextView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    tapMeButton = findViewById(R.id.tapMeButton)
    gameScoreTextView = findViewById(R.id.gameScoreTextView)
    timeLeftTextView = findViewById(R.id.timeLeftTextView)

    tapMeButton.setOnClickListener { view ->
      incrementScore()
    }
  }

  private fun incrementScore() {
    score += 1

    val newScore = getString(R.string.yourScore, score)
    gameScoreTextView.text = newScore
  }
}