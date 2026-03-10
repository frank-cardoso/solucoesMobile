# Soluções Mobile - Engenharia de Software

Este repositório contém os commits das aulas de Soluções Mobile da matéria de Engenharia de Software.

## Estrutura do Projeto

```
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
- **Comentários no código**: Documentação inline para lógicas complexas

### Templates
- **Android Base**: `android-projects/templates/` - Template para novos projetos Android
- **Estrutura padrão**: Configurações Gradle, arquitetura e documentação

## 🎯 Status dos Projetos

| Aula | Projeto | Status | Tecnologia | Funcionalidades |
|------|---------|--------|------------|-----------------|
| 01 | Validador de Senhas | ✅ Completo | Kotlin Console | Validação dinâmica, Menu interativo |
| 02 | Pedra, Papel e Tesoura | ✅ Funcional | Android/Compose | Jogo com animações, UI moderna |

## 🚀 Próximos Passos

### Para Aula 02 (Pedra, Papel e Tesoura)
- [ ] **Implementar efeitos sonoros** (opcional)
- [ ] **Adicionar vibração** no resultado
- [ ] **Criar APK** para distribuição
- [ ] **Testes unitários** para lógica do jogo

### Para Futuras Aulas
- [ ] **Usar template** em `android-projects/templates/`
- [ ] **Seguir convenções** estabelecidas
- [ ] **Manter documentação** atualizada
- [ ] **Implementar testes** automatizados

## 🎮 Features Implementadas - Pedra, Papel e Tesoura

### Core Features ✅
- **Sorteio aleatório** entre as três opções usando `Random()`
- **Animação visual** fluida durante sorteio (10 ciclos, 100ms cada)
- **Estados bem definidos** com `EstadoJogo` enum
- **Interface responsiva** adaptada para diferentes tamanhos de tela
- **Emojis representativos** de alta qualidade (🪨📃✂️)

### UI/UX ✅
- **Material Design 3** com theme customizado
- **Cards elevated** para hierarquia visual clara
- **Botão responsivo** que desabilita durante operações
- **Feedback visual** imediato em todos os estados
- **Tipografia consistente** seguindo guidelines Material
- **Cores acessíveis** com contraste adequado

### Arquitetura ✅
- **MVVM pattern** com Compose State management
- **Separação clara** de responsabilidades
- **Models tipados** (`OpcaoJogo`, `EstadoJogo`)
- **Componentes reutilizáveis** (`ImagemAnimada`)
- **Coroutines** para operações assíncronas
- **Estado gerenciado** com `remember` e `LaunchedEffect`

---

💡 **Dica**: Este repositório segue padrões profissionais e está pronto para desenvolvimento acadêmico e projetos reais. Cada exercício é independente e pode ser executado separadamente.

🎉 **A estrutura está 100% pronta para uso acadêmico e profissional!**
├── README.md
├── src/
│   └── main/
│       └── kotlin/
│           └── aula01/
│               └── validador_senhas/
│                   ├── models/
│                   │   └── Requisito.kt
│                   ├── engine/
│                   │   └── ValidadorSenha.kt
│                   ├── rules/
│                   │   └── RegrasValidacao.kt
│                   └── Main.kt
├── docs/
│   └── aula01/
│       └── exercicio_validador_senhas.md
└── .gitignore
```

## Aulas

### Aula 01 - Validador de Senhas Dinâmico ⚡ 

**Objetivo**: Desenvolver um motor de validação de senhas dinâmico e interativo em Kotlin, utilizando conceitos de Orientação a Objetos (POO) e Programação Funcional (Lambdas).

#### Funcionalidades
- ✅ Motor de validação com Data Class `Requisito`
- ✅ Engine de validação sequencial **otimizada com lambdas**
- ✅ Loop de interação contínua **usando generateSequence()**
- ✅ Regras de senha obrigatórias **com factory functions**
- ✅ Regras criativas adicionais **lazy evaluation**

#### Benefícios da Refatoração
- 🔥 **Performance**: Lazy evaluation e memoização
- 📖 **Legibilidade**: Extension functions e factory patterns
- 🛠️ **Manutenibilidade**: Código mais modular e reutilizável
- 🎯 **Funcional**: Uso extensivo de higher-order functions

## Requisitos do Sistema

- Kotlin
- JVM 8+

## Autor

Desenvolvido como parte da disciplina de Engenharia de Software - Soluções Mobile
