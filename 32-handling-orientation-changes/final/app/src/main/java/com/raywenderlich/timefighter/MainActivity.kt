package com.raywenderlich.timefighter

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  private var score = 0

  private var gameStarted = false
  private lateinit var countDownTimer: CountDownTimer
  private var initialCountDown: Long = 60000
  private var countDownInterval: Long = 1000

  private lateinit var tapMeButton: Button
  private lateinit var gameScoreTextView: TextView
  private lateinit var timeLeftTextView: TextView
  private var timeLeftOnTimer: Long = 60000

  companion object {
    private val TAG = MainActivity::class.java.simpleName
    private const val KEY_SCORE = "KEY_SCORE"
    private const val KEY_TIME_LEFT = "KEY_TIME_LEFT"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    Log.d(TAG, "onCreate called. Score is $score")

    tapMeButton = findViewById(R.id.tapMeButton)
    gameScoreTextView = findViewById(R.id.gameScoreTextView)
    timeLeftTextView = findViewById(R.id.timeLeftTextView)

    tapMeButton.setOnClickListener { view ->
      incrementScore()
    }

    resetGame()
  }

  override fun onSaveInstanceState(outState: Bundle) {
    outState.putInt(KEY_SCORE, score)
    outState.putLong(KEY_TIME_LEFT, timeLeftOnTimer)
    countDownTimer.cancel()

    Log.d(TAG, "onSaveInstanceState: Saving Score: $score & Time Left: $timeLeftOnTimer")
    super.onSaveInstanceState(outState)
  }

  override fun onDestroy() {
    Log.d(TAG, "onDestroy called.")
    super.onDestroy()
  }

  private fun resetGame() {
    score = 0

    gameScoreTextView.text = getString(R.string.yourScore, score)

    val initialTimeLeft = initialCountDown / 1000
    timeLeftTextView.text = getString(R.string.timeLeft, initialTimeLeft)

    countDownTimer = object : CountDownTimer(initialCountDown, countDownInterval) {
      override fun onTick(millisUntilFinished: Long) {
        timeLeftOnTimer = millisUntilFinished

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

  private fun incrementScore() {
    if (!gameStarted) {
      startGame()
    }

    score += 1

    val newScore = getString(R.string.yourScore, score)
    gameScoreTextView.text = newScore
  }

  private fun endGame() {
    Toast.makeText(this, getString(R.string.gameOverMessage, score), Toast.LENGTH_LONG).show()

    resetGame()
  }
}