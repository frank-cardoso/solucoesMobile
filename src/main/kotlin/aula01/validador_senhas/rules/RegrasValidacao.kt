package aula01.validador_senhas.rules

import aula01.validador_senhas.models.Requisito
import java.text.SimpleDateFormat
import java.util.*

object RegrasValidacao {

    val requisitos: List<Requisito> = listOf(
        Requisito(
            mensagemErro = "❌ A senha deve ter pelo menos 5 caracteres.",
            validacao = { senha -> senha.length >= 5 }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter pelo menos uma letra maiúscula.",
            validacao = { senha -> senha.any { it.isUpperCase() } }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter pelo menos um número.",
            validacao = { senha -> senha.any { it.isDigit() } }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter a palavra 'kotlin' (maiúsculas ou minúsculas).",
            validacao = { senha -> senha.lowercase().contains("kotlin") }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter o ano do Hexa: '2026'.",
            validacao = { senha -> senha.contains("2026") }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter pelo menos um emoji (ex: ❄️, 🔥, ⚡).",
            validacao = { senha ->
                senha.any { char ->
                    Character.UnicodeBlock.of(char) == Character.UnicodeBlock.EMOTICONS ||
                    Character.UnicodeBlock.of(char) == Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS ||
                    Character.UnicodeBlock.of(char) == Character.UnicodeBlock.SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS ||
                    Character.UnicodeBlock.of(char) == Character.UnicodeBlock.TRANSPORT_AND_MAP_SYMBOLS
                }
            }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter o dia atual em algarismos romanos (II para dia 2).",
            validacao = { senha ->
                val diaAtual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                val romanoAtual = converterParaRomano(diaAtual)
                senha.uppercase().contains(romanoAtual)
            }
        ),

        Requisito(
            mensagemErro = "❌ A soma dos números na senha deve ser pelo menos 15.",
            validacao = { senha ->
                val somaNumeros = senha.filter { it.isDigit() }
                    .sumOf { it.toString().toInt() }
                somaNumeros >= 15
            }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter exatamente o número de caracteres que ela possui no momento (meta-validação).",
            validacao = { senha ->
                val tamanho = senha.length
                senha.contains(tamanho.toString())
            }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter pelo menos uma letra de cada: maiúscula, minúscula e um símbolo especial.",
            validacao = { senha ->
                val temMaiuscula = senha.any { it.isUpperCase() }
                val temMinuscula = senha.any { it.isLowerCase() }
                val temEspecial = senha.any { !it.isLetterOrDigit() && !it.isWhitespace() }
                temMaiuscula && temMinuscula && temEspecial
            }
        ),

        Requisito(
            mensagemErro = "❌ A senha deve conter o mês atual abreviado em inglês (${obterMesAtual()}).",
            validacao = { senha ->
                val mesAtual = obterMesAtual()
                senha.lowercase().contains(mesAtual.lowercase())
            }
        )
    )

    private fun converterParaRomano(numero: Int): String {
        val valores = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val simbolos = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

        var num = numero
        val resultado = StringBuilder()

        for (i in valores.indices) {
            while (num >= valores[i]) {
                resultado.append(simbolos[i])
                num -= valores[i]
            }
        }

        return resultado.toString()
    }

    private fun obterMesAtual(): String {
        val formato = SimpleDateFormat("MMM", Locale.ENGLISH)
        return formato.format(Date())
    }
}
