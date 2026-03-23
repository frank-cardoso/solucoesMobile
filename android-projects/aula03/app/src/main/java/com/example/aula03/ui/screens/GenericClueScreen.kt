package com.example.aula03.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aula03.TreasureHuntViewModel

@Composable
fun GenericClueScreen(
    clueId: Int,
    riddle: String,
    viewModel: TreasureHuntViewModel,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val answer = viewModel.clueAnswers[clueId].orEmpty()
    var showError by remember(clueId) { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Pista $clueId",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = riddle,
            style = MaterialTheme.typography.bodyLarge
        )

        OutlinedTextField(
            value = answer,
            onValueChange = {
                showError = false
                viewModel.updateClueAnswer(clueId, it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Sua resposta") },
            singleLine = true,
            isError = showError
        )

        if (showError) {
            Text(
                text = "Resposta incorreta. Tente novamente.",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = onBackClick) {
                Text("Voltar")
            }

            Button(
                onClick = {
                    val isCorrect = viewModel.validateClue(clueId)
                    if (isCorrect) {
                        onNextClick()
                    } else {
                        showError = true
                    }
                }
            ) {
                Text("Próxima Pista")
            }
        }
    }
}

