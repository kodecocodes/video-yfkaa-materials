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
  var alertIsVisible by remember { mutableStateOf(false) }
  
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
      Text(text = stringResource(R.string.instruction_text))
      Text(
        text = stringResource(id = R.string.target_value_text),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
      )
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = stringResource(id = R.string.min_value_text),
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(start = 16.dp)
        )
        Slider(
          value = 0.5f,
          valueRange = 0.01f..1f,
          onValueChange = {},
          modifier = Modifier.weight(1f)
        )
        Text(
          text = stringResource(id = R.string.max_value_text),
          textAlign = TextAlign.Center,
          modifier = Modifier.padding(end = 16.dp)
        )
      }
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
        hideDialog = { alertIsVisible = false }
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