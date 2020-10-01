package com.raywenderlich.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
  internal lateinit var tapMeButton: Button
  internal lateinit var gameScoreTextView: TextView
  internal lateinit var timeLeftTextView: TextView

  internal var score = 0
  internal var gameStarted = false

  internal lateinit var countDownTimer: CountDownTimer
  internal val initialCountDown: Long = 60000
  internal val countDownInterval: Long = 1000

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    tapMeButton = findViewById(R.id.tapMeButton)
    gameScoreTextView = findViewById(R.id.gameScoreTextView)
    timeLeftTextView = findViewById(R.id.timeLeftTextView)

    tapMeButton.setOnClickListener { view ->
      incrementScore()
    }

    resetGame()
  }

  private fun incrementScore() {
    if (!gameStarted) {
      startGame()
    }

    score += 1
    val newScore = getString(R.string.yourScore, score)
    gameScoreTextView.text = newScore
  }

  private fun resetGame() {
    // Reset score
    score = 0

    // Show score
    gameScoreTextView.text = getString(R.string.yourScore, score)

    // Show initial time left
    val initialTimeLeft = initialCountDown / 1000
    timeLeftTextView.text = getString(R.string.timeLeft, initialTimeLeft)

    countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
      override fun onTick(millisUntilFinished: Long) {
        val timeLeft = millisUntilFinished / 1000
        timeLeftTextView.text = getString(R.string.timeLeft, timeLeft)
      }

      override fun onFinish() {
        endGame()
      }
    }

    gameStarted = false
  }

  private fun startGame() {
    countDownTimer.start()
    gameStarted = true
  }

  private fun endGame() {
    Toast.makeText(this, getString(R.string.gameOverMessage, score), Toast.LENGTH_LONG).show()
    resetGame()
  }
}
