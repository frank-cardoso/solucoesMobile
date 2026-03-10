package br.satc.pedrapapeltesoura.ui.components

import androidx.compose.foundation.layout.*
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

@Composable
fun ImagemAnimada(
    estado: EstadoJogo,
    opcaoAtual: OpcaoJogo?
) {
    var opcaoAnimacao by remember { mutableStateOf(OpcaoJogo.PEDRA) }

    // Animação durante sorteio
    LaunchedEffect(estado) {
        if (estado == EstadoJogo.SORTEANDO) {
            repeat(10) { // 10 ciclos de animação
                OpcaoJogo.values().forEach { opcao ->
                    opcaoAnimacao = opcao
                    delay(100) // 100ms por frame
                }
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (estado) {
            EstadoJogo.PRONTO -> {
                // Estado inicial - mostrar placeholder
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "🎲",
                        fontSize = 80.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Toque para jogar!",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }

            EstadoJogo.SORTEANDO -> {
                // Durante animação - mostrar opção atual da animação
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = opcaoAnimacao.emoji,
                        fontSize = 100.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "🔄 Sorteando...",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }

            EstadoJogo.RESULTADO -> {
                // Mostrar resultado final
                opcaoAtual?.let { opcao ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = opcao.emoji,
                            fontSize = 120.sp,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = opcao.nome,
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}
