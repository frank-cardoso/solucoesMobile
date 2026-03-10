package br.satc.pedrapapeltesoura.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import br.satc.pedrapapeltesoura.models.EstadoJogo
import br.satc.pedrapapeltesoura.models.OpcaoJogo
import br.satc.pedrapapeltesoura.ui.components.ImagemAnimada

@Composable
fun JogoPedraPapelTesoura() {
    var estadoAtual by remember { mutableStateOf(EstadoJogo.PRONTO) }
    var opcaoAtual by remember { mutableStateOf<OpcaoJogo?>(null) }
    var textoResultado by remember { mutableStateOf("Pronto para jogar!") }

    // Função para iniciar o jogo
    suspend fun iniciarJogo() {
        estadoAtual = EstadoJogo.SORTEANDO
        textoResultado = "Sorteando..."

        // Simula animação por 2 segundos
        delay(2000)

        // Sorteia resultado
        val resultado = OpcaoJogo.sortear()
        opcaoAtual = resultado
        textoResultado = resultado.nome.uppercase()
        estadoAtual = EstadoJogo.RESULTADO

        // Volta ao estado inicial após 3 segundos
        delay(3000)
        estadoAtual = EstadoJogo.PRONTO
        textoResultado = "Pronto para jogar!"
        opcaoAtual = null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Título do Jogo
        Text(
            text = "Pedra, Papel e Tesoura",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )

        // Área da Imagem/Animação
        Card(
            modifier = Modifier.size(250.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                ImagemAnimada(
                    estado = estadoAtual,
                    opcaoAtual = opcaoAtual
                )
            }
        }

        // Texto do Resultado
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Text(
                text = textoResultado,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        // Botão de Jogar
        Button(
            onClick = {
                if (estadoAtual == EstadoJogo.PRONTO) {
                    // Usar LaunchedEffect para operações suspensas
                    // Por enquanto, só mudamos o estado
                    estadoAtual = EstadoJogo.SORTEANDO
                    textoResultado = "Sorteando..."
                }
            },
            enabled = estadoAtual == EstadoJogo.PRONTO,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.outline
            )
        ) {
            Text(
                text = "JOGAR",
                style = MaterialTheme.typography.labelLarge.copy(fontSize = 18.sp),
                color = if (estadoAtual == EstadoJogo.PRONTO)
                    MaterialTheme.colorScheme.onPrimary
                else MaterialTheme.colorScheme.onSurface
            )
        }
    }

    // LaunchedEffect para gerenciar o jogo
    LaunchedEffect(estadoAtual) {
        if (estadoAtual == EstadoJogo.SORTEANDO) {
            iniciarJogo()
        }
    }
}



