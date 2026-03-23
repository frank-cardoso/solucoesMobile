package com.example.aula03.ui.screens

import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.aula03.R

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

    val context = LocalContext.current

    DisposableEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.som_tesouro)
        mediaPlayer?.start()

        onDispose {
            mediaPlayer?.stop()
            mediaPlayer?.release()
        }
    }

    BackHandler {
        onRestartClick()
    }

    val minutes = elapsedSeconds / 60
    val seconds = elapsedSeconds % 60
    val elapsedTime = "%02d:%02d".format(minutes, seconds)

    val imageResId = R.drawable.imagem_tesouro

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Imagem do tesouro",
            modifier = Modifier
                .size(220.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )

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
