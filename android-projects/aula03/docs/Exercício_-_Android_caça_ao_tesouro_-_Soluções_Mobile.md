# 🏴‍☠️ Caça ao Tesouro com Navegação entre Telas

## 🎯 Objetivo Principal
Desenvolver um aplicativo Android nativo usando **Jetpack Compose** e a ferramenta **Navigation** para navegar entre diferentes telas.

---

## 📝 Exercício Proposto
O exercício consiste em criar um aplicativo simples onde o usuário deve navegar por diferentes telas para encontrar um "tesouro" escondido. Em cada tela será apresentada uma pista, e o usuário deverá “descobrir a resposta” para poder avançar para a próxima tela até encontrar o tesouro.

### 📱 Telas do Aplicativo

* **Tela Inicial / Home:**
    * Apresenta um botão “iniciar caça ao tesouro”.
* **Telas de Pista (mínimo 3 telas):**
    * Exibe uma pista para o usuário, como uma charada ou uma pergunta simples.
    * Apresenta dois botões: **"Próxima Pista"** e **"Voltar"**.
    * O botão "Próxima Pista" leva o usuário para a próxima Tela / Pista.
    * O botão "Voltar" retorna para a tela anterior.
* **Tela de Tesouro (TreasureScreen):**
    * Exibe uma mensagem de sucesso, como *"Parabéns! Você encontrou o tesouro!"*.
    * Inclui um botão para voltar à tela inicial e recomeçar a caça ao tesouro.

---

## 🛠️ Instruções Técnicas
1.  Utilize o **Android Jetpack Compose** para criar as interfaces das telas.
2.  Implemente a navegação entre as telas usando o componente **NavHost** e **NavController** da ferramenta Navigation do Jetpack Compose.
3.  Teste o comportamento da pilha de telas, verificando se a navegação está adequada.

---

## ✨ Extras (Desafios Adicionais)
> [!TIP]
> Tente implementar estes recursos para enriquecer seu projeto:

* **Animações:** Pesquise como adicionar animações de transição entre as telas para tornar a navegação mais interessante.
* **Rastreamento de Tempo:** Adicione uma funcionalidade que rastreie o tempo que o usuário leva para encontrar o tesouro e exiba o tempo total na tela de tesouro.
* **Validação de Resposta:** Adicione um campo de texto na tela da pista para que o usuário insira a resposta; permita avançar apenas se o usuário acertar.
* **Botão Voltar:** Investigue o comportamento do botão de voltar físico do emulador/dispositivo após concluir o quiz.