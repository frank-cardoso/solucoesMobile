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
            println("\n" + "=" * 60)
            validador.executarValidacao()
            println("=" * 60 + "\n")
        },
        "2" to {
            println()
            validador.exibirRequisitos()
        },
        "3" to {
            listOf(
                "\n👋 Obrigado por usar o Validador de Senhas!",
                "📚 Continue estudando Kotlin e POO! 🎓"
            ).forEach(::println)
        }
    )

    generateSequence {
        listOf(
            "🎮 MENU PRINCIPAL:",
            "1. 🚀 Iniciar Desafio da Senha",
            "2. 📋 Ver Requisitos",
            "3. 🚪 Sair",
            "\nEscolha uma opção (1-3): "
        ).forEach(::print)

        readLine()
    }
    .takeWhile { it != "3" }
    .forEach { opcao ->
        acoes[opcao]?.invoke()
            ?: println("❌ Opção inválida! Escolha 1, 2 ou 3.\n")
    }

    acoes["3"]?.invoke()
}

/**
 * Extensão para repetir strings
 */
private operator fun String.times(n: Int): String {
    return this.repeat(n)
}
