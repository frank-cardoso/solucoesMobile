# 🛠️ Guia de Desenvolvimento - Soluções Mobile

## 📋 Convenções de Código

### Nomenclatura
- **Packages**: `snake_case` em português (ex: `validador_senhas`)
- **Classes/Interfaces**: `PascalCase` em português (ex: `ValidadorSenha`)
- **Métodos/Variáveis**: `camelCase` em português (ex: `validarSenha`)
- **Constantes**: `UPPER_SNAKE_CASE` em português (ex: `TAMANHO_MINIMO`)
- **Arquivos**: `snake_case` (ex: `validador_senha.kt`)

### Estrutura de Classes
```kotlin
// Exemplo de estrutura padrão
class ExemploClasse {
    // 1. Propriedades privadas
    private val propriedadePrivada: String = ""
    
    // 2. Propriedades públicas
    val propriedadePublica: String = ""
    
    // 3. Métodos públicos
    fun metodoPublico(): String {
        return propriedadePublica
    }
    
    // 4. Métodos privados
    private fun metodoPrivado() {
        // implementação
    }
}
```

## 📁 Organização de Projetos

### Kotlin Console
```
src/main/kotlin/aulaXX/nome_exercicio/
├── Main.kt                    # Ponto de entrada
├── engine/                    # Lógica principal
├── models/                    # Classes de modelo
├── rules/                     # Regras de negócio
└── utils/                     # Utilitários
```

### Android Projects
```
app/src/main/java/br/satc/nome_projeto/
├── MainActivity.kt
├── ui/
│   ├── theme/                 # Tema do app
│   ├── screens/               # Telas principais
│   └── components/            # Componentes reutilizáveis
├── models/                    # Classes de dados
├── utils/                     # Funções utilitárias
└── data/                      # Acesso a dados (se necessário)
```

## 🎨 Padrões de UI (Android)

### Jetpack Compose
```kotlin
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

### Material Design 3
- Use `MaterialTheme.colorScheme` para cores
- Aplique `MaterialTheme.typography` para textos
- Utilize componentes Material3 (Button, Card, etc.)

## 📝 Documentação

### Comentários em Código
```kotlin
/**
 * Classe responsável por validar senhas
 * 
 * @param requisitos Lista de requisitos para validação
 */
class ValidadorSenha(private val requisitos: List<Requisito>) {
    
    /**
     * Valida uma senha contra os requisitos definidos
     * 
     * @param senha Senha a ser validada
     * @return true se válida, false caso contrário
     */
    fun validar(senha: String): Boolean {
        // implementação
    }
}
```

### README.md de Projetos
Cada projeto deve conter:
1. **Título e descrição**
2. **Funcionalidades implementadas**
3. **Tecnologias utilizadas**
4. **Como executar**
5. **Estrutura do projeto**
6. **Screenshots/GIFs** (para Android)

## 🧪 Testes

### Kotlin Console
```kotlin
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ValidadorSenhaTest {
    
    @Test
    fun `deve validar senha correta`() {
        // Arrange
        val validador = ValidadorSenha()
        
        // Act
        val resultado = validador.validar("MinhaSenh@123")
        
        // Assert
        assertTrue(resultado)
    }
}
```

### Android (Compose)
```kotlin
@Test
fun botaoJogar_iniciaJogo() {
    composeTestRule.setContent {
        JogoPedraPapelTesoura()
    }
    
    composeTestRule
        .onNodeWithText("JOGAR")
        .performClick()
        
    composeTestRule
        .onNodeWithText("Sorteando...")
        .assertIsDisplayed()
}
```

## 🔄 Git Workflow

### Commits
Formato: `tipo(escopo): descrição`

Exemplos:
```
feat(aula02): implementar animação do jogo
fix(validador): corrigir validação de caracteres especiais
docs(readme): atualizar instruções de execução
refactor(models): reorganizar classes de modelo
```

### Branches
- `main`: Código estável e finalizado
- `aula-XX`: Branch para desenvolvimento de cada aula
- `feature/nome-funcionalidade`: Features específicas

## 🚀 Build e Deploy

### Kotlin Console
```bash
# Build
./gradlew build

# Executar
./gradlew run

# Testes
./gradlew test
```

### Android
```bash
# Build debug
./gradlew assembleDebug

# Build release
./gradlew assembleRelease

# Testes
./gradlew test
./gradlew connectedAndroidTest
```

## 📚 Recursos Úteis

### Documentação
- [Kotlin Official](https://kotlinlang.org/docs/)
- [Android Developers](https://developer.android.com/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)

### Ferramentas
- **Android Studio**: IDE principal para Android
- **IntelliJ IDEA**: Alternativa para projetos Kotlin console
- **Git**: Controle de versão
- **Gradle**: Sistema de build
