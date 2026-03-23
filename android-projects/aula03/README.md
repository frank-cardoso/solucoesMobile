# Caca ao Tesouro (aula03)

Aplicativo Android nativo em Kotlin + Jetpack Compose para praticar `navigation-compose`.

## Fluxo

`Home -> Pista 1 -> Pista 2 -> Pista 3 -> Tesouro`

## O que foi implementado

- Navegacao com `NavHost` e rotas via `sealed class`.
- Animacoes de transicao (fade + slide) entre telas.
- `TreasureHuntViewModel` com:
  - `StateFlow` para estado global (timer, progresso, fim de jogo).
  - Compose State para respostas digitadas por pista.
- `GenericClueScreen` reutilizavel com validacao de resposta.
- `TreasureScreen` com `BackHandler` e limpeza de back stack ao recomecar.

## Executar

Use Android Studio para rodar no emulador/dispositivo.

Ou via terminal:

```powershell
.\gradlew.bat :app:installDebug
```

## Estrutura principal

- `app/src/main/java/com/example/aula03/TreasureHuntViewModel.kt`
- `app/src/main/java/com/example/aula03/navigation/TreasureRoutes.kt`
- `app/src/main/java/com/example/aula03/navigation/TreasureHuntNavGraph.kt`
- `app/src/main/java/com/example/aula03/ui/screens/HomeScreen.kt`
- `app/src/main/java/com/example/aula03/ui/screens/GenericClueScreen.kt`
- `app/src/main/java/com/example/aula03/ui/screens/TreasureScreen.kt`

