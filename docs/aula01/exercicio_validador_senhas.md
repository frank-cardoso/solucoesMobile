# EXERCÍCIO - THE PASSWORD OVERLORD

**Peso: 0,5**

---

## 📌 Objetivo

Desenvolver um motor de validação de senhas dinâmico e interativo em Kotlin, utilizando os conceitos de Orientação a Objetos (POO) e Programação Funcional (Lambdas). O sistema deve desafiar o utilizador a criar uma "senha absoluta", validando requisitos complexos um de cada vez, simulando a lógica de um validador de frontend moderno.

---

## 🎯 Requisitos do Sistema

### 1. Criar a Classe Requisito (Data Class)
Cada requisito de segurança deve ser encapsulado numa data class contendo:
- **mensagemErro** (String): A mensagem explicativa que será exibida caso a regra falhe.
- **validação** (Lambda): Uma função que recebe a senha (String) e retorna um Booleano (true se válido, false se inválido).

### 2. Implementar a Engine de Validação
O sistema deve possuir uma lista centralizada de objetos Requisito. A lógica de validação deve:
- Percorrer a lista sequencialmente.
- Interromper o processamento no primeiro erro encontrado (break).
- Exibir apenas a mensagem de erro correspondente ao utilizador (Foco em UX).

### 3. Criar o Loop de Interação
Utilizar uma estrutura de repetição (do...while) para que o sistema solicite a senha continuamente até que todos os requisitos sejam satisfeitos com sucesso.

---

## 🛠 Regras de Senha Obrigatórias

O algoritmo deve validar pontos inspirados no "Password Game", por exemplo:

- **Comprimento Mínimo**: Pelo menos 5 caracteres.
- **Complexidade Básica**: Deve conter pelo menos uma letra maiúscula e um número.
- **Contexto Específico**: Deve conter uma palavra específica (sem distinguir maiúsculas/minúsculas).
- **Evento Histórico**: Deve conter o ano do Hexa ("2026").
- **Identidade Visual**: Deve conter pelo menos um Emoji (ex: ❄).

---

## 🚀 Desafio de Criatividade

Além das regras acima, o aluno deve inventar e implementar novas validações extras.

**Dica**: Seja criativo! Pode validar se a senha contém o dia atual em algarismos romanos, se a soma de números na senha atinge um valor, ou se contém o número exato de caracteres que a senha possui no momento.

---

## 🏫 Instituição

**CENTRO UNIVERSITÁRIO SATC**  
**ENGENHARIA DE SOFTWARE - DISCIPLINA DE SOLUÇÕES MOBILE**  
**Professor:** Thyerri Mezzari

---

## 💻 EXEMPLO DE ESTRUTURA (TESTE)

```kotlin
fun main() {
    // 1. Definição da lista de requisitos
    val listaDeRegras = listOf(
        Requisito("Mínimo de 5 caracteres") { it.length >= 5 },
        Requisito("Deve conter o ano do Hexa (2026)") { it.contains("2026") }
        // Adicione as demais regras e as suas 3 criações extras aqui
    )

    var senhaAprovada = false

    // 2. Loop de tentativa e erro
    do {
        println("\nDigite sua senha:")
        val entrada = readLine() ?: "" // Null Safety com operador Elvis

        var erroEncontrado: String? = null

        for (regra in listaDeRegras) {
            if (!regra.validacao(entrada)) {
                erroEncontrado = regra.mensagemErro
                break
            }
        }

        if (erroEncontrado != null) {
            println("❌ ERRO: $erroEncontrado")
        } else {
            println("✅ SUCESSO! Senha aceite pelo Overlord.")
            senhaAprovada = true
        }
    } while (!senhaAprovada)
}
```
