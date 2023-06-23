package com.yourcompany.bullseye

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.yourcompany.bullseye.ui.theme.BullseyeTheme


@Composable
fun GameScreen() {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "PUT THE BULLSEYE AS CLOSE AS YOU CAN TO")
    Text(text = "89", fontSize = 32.sp, fontWeight = FontWeight.Bold)
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(text = "1")
      Slider(
        value = 0.5f,
        valueRange = 0.01f..1f,
        onValueChange = {}
      )
      Text(text = "100")
    }
    Button(onClick = { }) {
      Text(text = "HIT ME")
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