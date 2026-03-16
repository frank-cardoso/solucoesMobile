# Soluções Mobile - Engenharia de Software

Este repositório contém os commits das aulas de Soluções Mobile da matéria de Engenharia de Software.

## Estrutura do Projeto

# 📱 Soluções Mobile - Repositório de Exercícios

Repositório para exercícios e projetos da disciplina de **Soluções Mobile** do curso de Engenharia de Software.

## 🎓 Informações Acadêmicas

- **Instituição**: Centro Universitário SATC
- **Curso**: Engenharia de Software
- **Disciplina**: Soluções Mobile
- **Professor**: Thyerri Mezzari

## 📁 Estrutura do Projeto

```
solucoesMobile/
├── kotlin-console/           # Exercícios Kotlin console
│   ├── src/main/kotlin/
│   │   └── aula01/          # ✅ Validador de Senhas
│   └── build.gradle.kts
├── android-projects/         # Projetos Android Studio
│   ├── aula02/              # ✅ Pedra, Papel e Tesoura
│   │   ├── app/             # Código fonte do app
│   │   ├── docs/            # Documentação específica
│   │   └── README.md        # Detalhes do projeto
│   └── templates/           # Templates para novos projetos
└── docs/                    # Documentação geral
    ├── guidelines/          # Guias de desenvolvimento
    ├── setup/              # Configurações
    └── resources/          # Recursos compartilhados
```

## 🛠️ Tecnologias Utilizadas

### Projetos Kotlin Console
- **Linguagem**: Kotlin 1.9.22
- **Build**: Gradle Kotlin DSL
- **Paradigma**: Orientação a Objetos
- **IDE**: IntelliJ IDEA / Android Studio

### Projetos Android
- **Framework**: Android SDK 34
- **UI**: Jetpack Compose com Material Design 3
- **Linguagem**: Kotlin 1.9.22
- **Build**: Gradle Android Plugin
- **Mín SDK**: API 24 (Android 7.0)

## 📚 Exercícios Desenvolvidos

### 🔐 **Aula 01 - Validador de Senhas (Kotlin Console)**
- **📂 Localização**: `kotlin-console/src/main/kotlin/aula01/validador_senhas/`
- **🛠️ Tecnologias**: Kotlin, POO, Regex, Enum Classes
- **⚡ Funcionalidades**: 
  - Validação dinâmica de senhas com múltiplos requisitos
  - Interface de menu interativa
  - Sistema de regras configurável
  - Feedback detalhado para o usuário

### 🎮 **Aula 02 - Pedra, Papel e Tesoura (Android)**
- **📂 Localização**: `android-projects/aula02/`
- **🛠️ Tecnologias**: Android, Jetpack Compose, Material Design 3, Kotlin Coroutines
- **⚡ Funcionalidades**: 
  - ✅ **Jogo interativo** com animações suaves
  - ✅ **Sorteio aleatório** entre Pedra (🪨), Papel (📃) e Tesoura (✂️)
  - ✅ **Interface moderna** e intuitiva
  - ✅ **Estados bem gerenciados**: Pronto → Sorteando → Resultado → Pronto
  - ✅ **Animação visual** durante sorteio (10 ciclos com delay)
  - ✅ **Cards elevated** para melhor hierarquia visual
  - ✅ **Modo presencial** - cada jogador usa seu próprio celular
  - 🔄 **Efeitos sonoros** (estrutura criada, implementação pendente)

## 🚀 Como Executar

### Projetos Kotlin Console
```bash
cd kotlin-console/
./gradlew run
```

### Projetos Android
1. **Abrir Android Studio**
2. **Navegar** até `android-projects/aula02/`
3. **Sincronizar** projeto Gradle
4. **Executar** em dispositivo/emulador (API 24+)

```bash
# Build e instalação via terminal
cd android-projects/aula02/
./gradlew assembleDebug
./gradlew installDebug
```

## 🎯 Como Jogar - Pedra, Papel e Tesoura

1. **📱 Abra o app** no seu celular
2. **👥 Encontre um amigo** com o mesmo app
3. **🔢 Contem até 3** juntos
4. **🎮 Apertem "JOGAR"** simultaneamente
5. **👀 Comparem os resultados** exibidos nas telas
6. **🏆 Determinem o vencedor** pelas regras clássicas:
   - 🪨 Pedra quebra ✂️ Tesoura
   - ✂️ Tesoura corta 📃 Papel  
   - 📃 Papel embrulha 🪨 Pedra

## 🔧 Configuração de Desenvolvimento

### Pré-requisitos
- **JDK**: 17 ou superior
- **Android Studio**: Hedgehog (2023.1.1) ou superior
- **Kotlin**: 1.9.22
- **Gradle**: 8.2+
- **Android SDK**: API 34
- **Dispositivo**: Android 7.0+ (API 24+)

### Setup Inicial
```bash
git clone [URL_DO_REPOSITORIO]
cd solucoesMobile
```

## 📝 Convenções de Desenvolvimento

### Nomenclatura
- **Packages**: `snake_case` em português (ex: `pedra_papel_tesoura`)
- **Classes**: `PascalCase` em português (ex: `ValidadorSenha`)
- **Métodos/Variáveis**: `camelCase` em português (ex: `validarSenha`)
- **Constantes**: `UPPER_SNAKE_CASE` (ex: `TAMANHO_MINIMO`)
- **Aulas**: Numeração sequencial (`aula01`, `aula02`, etc.)

### Estrutura de Código Android
```kotlin
// Estrutura padrão para Composables
@Composable
fun ExemploTela(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // Conteúdo da tela
    }
}
```

## 🎨 Arquitetura dos Projetos

### Android - Organização por Features
```
app/src/main/java/br/satc/nome_projeto/
├── MainActivity.kt           # Activity principal
├── ui/
│   ├── theme/               # Tema Material Design 3
│   ├── screens/             # Telas principais  
│   └── components/          # Componentes reutilizáveis
├── models/                  # Classes de dados/enum
├── utils/                   # Funções utilitárias
└── data/                    # Acesso a dados (opcional)
```

### Kotlin Console - Organização por Domínio
```
src/main/kotlin/aulaXX/nome_exercicio/
├── Main.kt                  # Ponto de entrada
├── engine/                  # Lógica principal
├── models/                  # Classes de modelo
├── rules/                   # Regras de negócio
└── utils/                   # Utilitários
```

## 📖 Documentação

### Estrutura
- **README.md principal**: Visão geral do repositório (este arquivo)
- **README.md por projeto**: Detalhes específicos de cada exercício
- **docs/guidelines/**: Guias de desenvolvimento e boas práticas

### Templates
- **Android Base**: `android-projects/templates/` - Template para novos projetos Android
- **Estrutura padrão**: Configurações Gradle, arquitetura e documentação

## 🎯 Status dos Projetos

| Aula | Projeto | Status | Tecnologia | Funcionalidades |
|------|---------|--------|------------|-----------------|
| 01 | Validador de Senhas | ✅ Completo | Kotlin Console | Validação dinâmica, Menu interativo |
| 02 | Pedra, Papel e Tesoura | ✅ Funcional | Android/Compose | Jogo com animações, UI moderna |

## Autor

Desenvolvido como parte da disciplina de Engenharia de Software - Soluções Mobile
