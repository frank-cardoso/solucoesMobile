package aula01.validador_senhas

import aula01.validador_senhas.engine.ValidadorSenha

/**
 * Ponto de entrada principal da aplicação do Validador de Senhas.
 */
fun main() {
    val validador = ValidadorSenha()

    // Exibe uma mensagem de boas-vindas
    println("╔══════════════════════════════════════════════════╗")
    println("║         VALIDADOR DE SENHAS DINÂMICO             ║")
    println("║    Aula 01 - Soluções Mobile | Eng. Software     ║")
    println("╚══════════════════════════════════════════════════╝\n")

    // Menu principal
    while (true) {
        println("🎮 MENU PRINCIPAL:")
        println("1. 🚀 Iniciar Desafio da Senha")
        println("2. 📋 Ver Requisitos")
        println("3. 🚪 Sair")
        print("\nEscolha uma opção (1-3): ")

        when (readLine()) {
            "1" -> {
                println("\n" + "=" * 60)
                validador.executarValidacao()
                println("=" * 60 + "\n")
            }
            "2" -> {
                println()
                validador.exibirRequisitos()
            }
            "3" -> {
                println("\n👋 Obrigado por usar o Validador de Senhas!")
                println("📚 Continue estudando Kotlin e POO! 🎓")
                break
            }
            else -> {
                println("❌ Opção inválida! Escolha 1, 2 ou 3.\n")
            }
        }
    }
}

/**
 * Extensão para repetir strings
 */
private operator fun String.times(n: Int): String {
    return this.repeat(n)
}
