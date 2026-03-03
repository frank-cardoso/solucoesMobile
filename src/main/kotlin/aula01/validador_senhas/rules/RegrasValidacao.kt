package aula01.validador_senhas.rules

import aula01.validador_senhas.models.Requisito
import java.text.SimpleDateFormat
import java.util.*

object RegrasValidacao {

    private fun Int.toRoman(): String {
        val valores = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val simbolos = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

        var num = this
        return buildString {
            valores.indices.forEach { i ->
                while (num >= valores[i]) {
                    append(simbolos[i])
                    num -= valores[i]
                }
            }
        }
    }

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
    private fun String.hasEmoji(): Boolean {
        val knownEmojis = listOf("❄", "🔥", "⚡", "🔐", "🔒", "🔓", "😀", "🚀", "💻", "🎯", "⭐", "❤")

        // Primeiro: verificar se contém emojis da lista conhecida
        if (knownEmojis.any { this.contains(it) }) {
            return true
        }

        // Segundo: verificação por regex Unicode (mais robusta para multi-byte)
        val emojiRegex = Regex("[\u2600-\u27BF]|[\uD83C][\uDF00-\uDFFF]|[\uD83D][\uDC00-\uDE4F]|[\uD83D][\uDE80-\uDEFF]")
        if (emojiRegex.containsMatchIn(this)) {
            return true
        }

        // Terceiro: verificação por código Unicode (fallback)
        return this.any { char ->
            val code = char.code
            code in 0x1F300..0x1F6FF || // Faixa principal de emojis
            code in 0x2600..0x26FF ||   // Símbolos diversos
            code in 0x2700..0x27BF      // Dingbats
        }
    }

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
            senha.hasPattern { char -> !char.isLetterOrDigit() && !char.isWhitespace() }
        ).all { it }
    }

    val requisitos: List<Requisito> = listOf(
        minLength(5),
        hasCharType("letra maiúscula", Char::isUpperCase),
        hasCharType("número", Char::isDigit),
        contains("kotlin", "a palavra 'kotlin' (maiúsculas ou minúsculas)"),
        contains("2026", "o ano do Hexa: '2026'"),

        requisito("A senha deve conter pelo menos um emoji (ex: ❄️, 🔥, ⚡, 🔐)") { it.hasEmoji() },

        requisito("A senha deve conter o dia atual em algarismos romanos ($diaAtualRomano para dia ${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)})")
        { it.uppercase().contains(diaAtualRomano) },

        requisito("A soma dos números na senha deve ser pelo menos 15") { it.digitSum() >= 15 },

        requisito("A senha deve conter exatamente o número de caracteres que ela possui no momento (meta-validação)")
        { senha -> senha.contains(senha.length.toString()) },

        requisito("A senha deve conter pelo menos uma letra de cada: maiúscula, minúscula e um símbolo especial", complexCharValidation),

        requisito("A senha deve conter o mês atual abreviado em inglês ($mesAtual)") { it.containsIgnoreCase(mesAtual) }
    )
}
