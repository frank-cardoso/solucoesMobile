# Soluções Mobile - Engenharia de Software

Este repositório contém os commits das aulas de Soluções Mobile da matéria de Engenharia de Software.

## Estrutura do Projeto

```
solucoesMobile/
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
