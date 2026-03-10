# 🎮 Pedra, Papel e Tesoura - Aula 02

Aplicativo Android desenvolvido para a disciplina de Soluções Mobile usando Jetpack Compose.

## 📱 Sobre o App

Jogo clássico de Pedra, Papel e Tesoura para ser jogado presencialmente com amigos. Cada jogador usa seu próprio celular e, ao apertar "JOGAR" simultaneamente, comparam os resultados exibidos na tela.

## ✨ Funcionalidades Implementadas

- ✅ **Interface Intuitiva**: UI limpa e moderna com Material Design 3
- ✅ **Animação Visual**: As imagens alternam durante o sorteio criando efeito de suspense
- ✅ **Sorteio Aleatório**: Resultado escolhido randomicamente entre as três opções
- ✅ **Estados do Jogo**: Pronto → Sorteando → Resultado → Pronto
- ✅ **Emojis Visuais**: Representação clara de cada opção (🪨📃✂️)
- 🔄 **Efeitos Sonoros**: TODO - Implementar áudio durante jogadas
- 🔄 **Vibração**: TODO - Feedback tátil no resultado

## 🏗️ Arquitetura

### Estrutura do Projeto
```
app/src/main/java/br/satc/pedrapapeltesoura/
├── MainActivity.kt                 # Activity principal
├── models/
│   └── JogoModels.kt              # OpcaoJogo, EstadoJogo
├── ui/
│   ├── theme/                     # Tema do app
│   ├── screens/
│   │   └── JogoPedraPapelTesoura.kt  # Tela principal
│   └── components/
│       └── ImagemAnimada.kt       # Componente de animação
└── utils/
    └── AudioManager.kt            # Gerenciador de áudio (TODO)
```

### Tecnologias
- **Jetpack Compose** - UI declarativa
- **Material Design 3** - Sistema de design
- **Kotlin Coroutines** - Gerenciamento de estados assíncronos
- **StateFlow/Remember** - Gerenciamento de estado

## 🎯 Como Jogar

1. **Abra o app** no seu celular
2. **Encontre um amigo** com o mesmo app
3. **Contem até 3** juntos
4. **Apertem "JOGAR"** simultaneamente
5. **Comparem os resultados** exibidos nas telas
6. **Determinem o vencedor** pelas regras clássicas:
   - 🪨 Pedra quebra ✂️ Tesoura
   - ✂️ Tesoura corta 📃 Papel  
   - 📃 Papel embrulha 🪨 Pedra

## 🛠️ Desenvolvimento

### Pré-requisitos
- Android Studio Hedgehog (2023.1.1) ou superior
- Kotlin 1.9.22
- Android SDK 34
- Dispositivo/Emulador com Android API 24+ (Android 7.0)

### Executar o Projeto
```bash
# Clonar o repositório
git clone [URL_DO_REPO]

# Navegar para o projeto
cd solucoesMobile/android-projects/aula02/

# Abrir no Android Studio
```

### Build e Instalação
```bash
# Build debug
./gradlew assembleDebug

# Instalar no dispositivo
./gradlew installDebug
```

## 🎓 Exercício Acadêmico

**Disciplina**: Soluções Mobile  
**Professor**: Thyerri Mezzari  
**Instituição**: Centro Universitário SATC  
**Curso**: Engenharia de Software

### Requisitos Atendidos
- [x] Imagens representando pedra, papel e tesoura
- [x] Animação durante sorteio
- [x] Resultado aleatório
- [x] Interface adequada para smartphones
- [ ] Efeito sonoro (em desenvolvimento)

## 📄 Licença

Este projeto é desenvolvido para fins acadêmicos.
