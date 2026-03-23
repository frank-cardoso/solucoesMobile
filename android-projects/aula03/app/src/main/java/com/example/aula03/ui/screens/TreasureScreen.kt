package com.example.aula03.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TreasureScreen(
    elapsedSeconds: Int,
    onReachedTreasure: () -> Unit,
    onRestartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        onReachedTreasure()
    }

    BackHandler {
        onRestartClick()
    }

    val minutes = elapsedSeconds / 60
    val seconds = elapsedSeconds % 60
    val elapsedTime = "%02d:%02d".format(minutes, seconds)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Parabéns! Você encontrou o tesouro!",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Tempo total: $elapsedTime",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = onRestartClick,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text("Recomeçar")
        }
    }
}
