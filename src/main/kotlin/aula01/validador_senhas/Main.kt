package aula01.validador_senhas

import aula01.validador_senhas.engine.ValidadorSenha

fun main() {
    val validador = ValidadorSenha()

    fun exibirHeader() {
        listOf(
            "╔══════════════════════════════════════════════════╗",
            "║         VALIDADOR DE SENHAS DINÂMICO             ║",
            "║    Aula 01 - Soluções Mobile | Eng. Software     ║",
            "╚══════════════════════════════════════════════════╝\n"
        ).forEach(::println)
    }

    exibirHeader()

    val acoes = mapOf(
        "1" to {
            println("\n" + "=".repeat(60))
            validador.executarValidacao()
            println("=".repeat(60))
        },
        "2" to {
            println()
            validador.exibirRequisitos()
        },
        "3" to {
            println("\n👋 Obrigado por usar o Validador de Senhas!")
            println("📚 Continue estudando Kotlin e POO! 🎓")
        }
    )

    generateSequence {
        println("\n🎮 MENU PRINCIPAL:")
        println("┌─────────────────────────────────────┐")
        println("│ 1. 🚀 Iniciar Desafio da Senha     │")
        println("│ 2. 📋 Ver Requisitos                │")
        println("│ 3. 🚪 Sair                          │")
        println("└─────────────────────────────────────┘")
        print("\n➤ Escolha uma opção (1-3): ")

        readLine()
    }
    .takeWhile { it != "3" }
    .forEach { opcao ->
        acoes[opcao]?.invoke()
            ?: println("\n❌ Opção inválida! Por favor, escolha 1, 2 ou 3.")
    }

    acoes["3"]?.invoke()
}

/**
 * Extensão para repetir strings
 */
private operator fun String.times(n: Int): String {
    return this.repeat(n)
}
