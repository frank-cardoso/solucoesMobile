package aula01.validador_senhas.rules

import aula01.validador_senhas.models.Requisito
import java.text.SimpleDateFormat
import java.util.*

object RegrasValidacao {

    private val mesAtual by lazy {
        SimpleDateFormat("MMM", Locale.ENGLISH).format(Date())
    }

    private val diaAtualRomano by lazy {
        Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toRoman()
    }

    private val blocosEmoji by lazy {
        setOf(
            Character.UnicodeBlock.EMOTICONS,
            Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS,
            Character.UnicodeBlock.SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS,
            Character.UnicodeBlock.TRANSPORT_AND_MAP_SYMBOLS
        )
    }

    private fun String.hasMinLength(min: Int) = length >= min
    private fun String.hasPattern(predicate: (Char) -> Boolean) = any(predicate)
    private fun String.containsIgnoreCase(text: String) = lowercase().contains(text.lowercase())
    private fun String.digitSum() = filter(Char::isDigit).sumOf { it.digitToInt() }
    private fun String.hasEmoji() = any { blocosEmoji.contains(Character.UnicodeBlock.of(it)) }

    private fun requisito(message: String, validation: (String) -> Boolean) = Requisito(
        mensagemErro = "❌ $message.",
        validacao = validation
    )

    private fun minLength(size: Int) = requisito(
        "A senha deve ter pelo menos $size caracteres"
    ) { it.hasMinLength(size) }

    private fun hasCharType(tipo: String, predicate: (Char) -> Boolean) = requisito(
        "A senha deve conter pelo menos um $tipo"
    ) { it.hasPattern(predicate) }

    private fun contains(text: String, description: String = text) = requisito(
        "A senha deve conter $description"
    ) { it.containsIgnoreCase(text) }

    private val complexCharValidation: (String) -> Boolean = { senha ->
        listOf(
            senha.hasPattern(Char::isUpperCase),
            senha.hasPattern(Char::isLowerCase),
            senha.hasPattern { !it.isLetterOrDigit() && !it.isWhitespace() }
        ).all { it }
    }

    val requisitos: List<Requisito> = listOf(
        minLength(5),
        hasCharType("letra maiúscula", Char::isUpperCase),
        hasCharType("número", Char::isDigit),
        contains("kotlin", "a palavra 'kotlin' (maiúsculas ou minúsculas)"),
        contains("2026", "o ano do Hexa: '2026'"),

        requisito("A senha deve conter pelo menos um emoji (ex: ❄️, 🔥, ⚡)") { it.hasEmoji() },

        requisito("A senha deve conter o dia atual em algarismos romanos ($diaAtualRomano para dia ${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)})")
        { it.uppercase().contains(diaAtualRomano) },

        requisito("A soma dos números na senha deve ser pelo menos 15") { it.digitSum() >= 15 },

        requisito("A senha deve conter exatamente o número de caracteres que ela possui no momento (meta-validação)")
        { senha -> senha.contains(senha.length.toString()) },

        requisito("A senha deve conter pelo menos uma letra de cada: maiúscula, minúscula e um símbolo especial", complexCharValidation),

        requisito("A senha deve conter o mês atual abreviado em inglês ($mesAtual)") { it.containsIgnoreCase(mesAtual) }
    )

    private val romanCache = mutableMapOf<Int, String>()
    private fun Int.toRoman(): String = romanCache.getOrPut(this) {
        val valores = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val simbolos = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

        var num = this
        buildString {
            valores.indices.forEach { i ->
                while (num >= valores[i]) {
                    append(simbolos[i])
                    num -= valores[i]
                }
            }
        }
    }
}
