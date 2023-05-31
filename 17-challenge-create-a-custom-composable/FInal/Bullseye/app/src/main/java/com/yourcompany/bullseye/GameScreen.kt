package com.yourcompany.bullseye

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yourcompany.bullseye.ui.theme.BullseyeTheme


@Composable
fun GameScreen() {
  var alertIsVisible by rememberSaveable { mutableStateOf(false) }
  var sliderValue by rememberSaveable { mutableStateOf(0.5f) }

  val sliderToInt = (sliderValue * 100).toInt()
  
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    Spacer(modifier = Modifier.weight(.5f))
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceEvenly,
      modifier = Modifier.weight(9f)
    ) {
      GamePrompt()
      TargetSlider(
        value = sliderValue,
        valueChanged = { value ->
          sliderValue = value
        }
      )
      Button(onClick = {
        alertIsVisible = true
        Log.i("ALERT VISIBLE?", alertIsVisible.toString())
      }) {
        Text(text = stringResource(id = R.string.hit_me_button_text))
      }
    }
    Spacer(modifier = Modifier.weight(.5f))
    
    if (alertIsVisible) {
      ResultDialog(
        hideDialog = { alertIsVisible = false },
        sliderValue = sliderToInt
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
  BullseyeTheme {
    GameScreen()
  }
}