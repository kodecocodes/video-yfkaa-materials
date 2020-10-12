package com.raywenderlich.timefighter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  private lateinit var tapMeButton: Button
  private lateinit var gameScoreTextView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    tapMeButton = findViewById(R.id.tapMeButton)
    gameScoreTextView = findViewById(R.id.gameScoreTextView)
  }
}