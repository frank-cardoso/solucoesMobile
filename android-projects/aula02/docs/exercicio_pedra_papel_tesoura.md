# EXERCÍCIO - PEDRA, PAPEL E TESOURA

---

## 📌 Objetivo

Desenvolver um aplicativo de Pedra, Papel e Tesoura utilizando Android Studio, Kotlin e Jetpack Compose. O projeto deve ser publicado no GitHub e o link enviado no portal do aluno dentro do prazo.

---

## 🎯 Requisitos do Sistema

Desenvolver um app de Pedra, Papel e Tesoura com foco em uma experiência divertida para jogar com amigos presencialmente. Cada jogador utilizará o seu próprio celular: ambos devem apertar o botão “Jogar” ao mesmo tempo e, em seguida, mostrar o resultado exibido na tela.

- **Imagens:** O app deve exibir imagens para pedra, papel e tesoura.
- **Animação:** Durante o sorteio, as imagens devem alternar na tela antes de mostrar o resultado final.
- **Aleatoriedade:** O resultado deve ser escolhido aleatoriamente entre pedra, papel e tesoura.
- **Sonoplastia:** O app deve reproduzir um efeito de áudio ao iniciar ou finalizar a jogada.
- **UX/UI:** A interface deve ser agradável, organizada e adequada para uso em smartphones.

---

## 🔹 Dicas

- 📌 **Inicie pela camada visual:** monte primeiro a interface com título, imagens, área de resultado e botão “Jogar”. Depois implemente a lógica do sorteio.
- 📌 **Busque os recursos:** O aluno deverá buscar imagens para representar pedra, papel e tesoura. Essas imagens devem ser exibidas no app e devem ficar alternando enquanto o sorteio acontece, criando um efeito visual de animação.
- 📌 **Ação do Botão:** O app deve possuir um botão “Jogar”. Ao tocar nele, o aplicativo deve tocar um efeito de áudio e realizar o sorteio de forma aleatória, exibindo ao final o resultado na tela.
- 📌 **Modo Offline:** Não é necessário que os celulares se comuniquem entre si. A proposta é que os amigos joguem lado a lado, apertando “Jogar” juntos e comparando o resultado exibido em cada aparelho.

---

## 🏫 Instituição

**CENTRO UNIVERSITÁRIO SATC** **ENGENHARIA DE SOFTWARE - DISCIPLINA DE SOLUÇÕES MOBILE** **Professor:** Thyerri Mezzari

---

## 💻 EXEMPLO DE ESTRUTURA (TESTE EM COMPOSE)

```kotlin
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun JogoPedraPapelTesoura() {
    // 1. Estados da Tela
    var resultadoAtual by remember { mutableStateOf("Pronto para jogar!") }
    var sorteando by remember { mutableStateOf(false) }

    // 2. Estrutura Visual
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Título
        Text(text = "Pedra, Papel e Tesoura", style = MaterialTheme.typography.headlineMedium)

        // Área da Imagem (Placeholder)
        Box(
            modifier = Modifier.size(200.dp),
            contentAlignment = Alignment.Center
        ) {
            if (sorteando) {
                Text("Animando imagens... 🔄")
            } else {
                Text("Imagem do Resultado 🖼️")
            }
        }

        // Texto do Resultado
        Text(text = resultadoAtual, style = MaterialTheme.typography.titleLarge)

        // Botão de Jogar
        Button(
            onClick = {
                // TODO: Tocar áudio aqui
                // TODO: Iniciar loop de animação das imagens
                // TODO: Sortear resultado final
                resultadoAtual = "Sorteando..."
                sorteando = true
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "JOGAR", style = MaterialTheme.typography.labelLarge)
        }
    }
}