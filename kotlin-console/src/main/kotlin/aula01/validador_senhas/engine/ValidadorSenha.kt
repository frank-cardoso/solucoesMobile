package aula01.validador_senhas.engine

import aula01.validador_senhas.models.Requisito
import aula01.validador_senhas.rules.RegrasValidacao

class ValidadorSenha {

    private val requisitos: List<Requisito> = RegrasValidacao.requisitos

    fun validarSenha(senha: String): Pair<Boolean, String?> =
        requisitos.find { !it.validacao(senha) }
            ?.let { false to it.mensagemErro }
            ?: (true to null)

    fun executarValidacao() {
        println("🔐 BEM-VINDO AO VALIDADOR DE SENHAS ABSOLUTO! 🔐")
        println("Crie uma senha que atenda a todos os requisitos para vencer o desafio!\n")

        var senhaValida = false
        var tentativas = 0

        do {
            tentativas++
            print("Tentativa #$tentativas - Digite sua senha: ")
            val senha = readLine() ?: ""

            val (isValid, mensagemErro) = validarSenha(senha)

            if (isValid) {
                senhaValida = true
                println("\n🎉 PARABÉNS! Você criou uma senha absoluta! 🎉")
                println("✅ Senha aceita: '$senha'")
                println("🏆 Requisitos atendidos: ${requisitos.size}")
                println("🎯 Tentativas necessárias: $tentativas")
            } else {
                println("\n$mensagemErro")
                println("🔄 Tente novamente...\n")
            }

        } while (!senhaValida)
    }

    fun exibirRequisitos() {
        println("📋 LISTA DE REQUISITOS:")
        println("=" * 50)

        requisitos
            .mapIndexed { index, requisito ->
                "${index + 1}. ${requisito.mensagemErro.removePrefix("❌ ")}"
            }
            .forEach(::println)

        println("=" * 50)
        println()
    }
}

private operator fun String.times(n: Int): String {
    return this.repeat(n)
}
