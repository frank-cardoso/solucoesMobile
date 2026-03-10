package br.satc.pedrapapeltesoura.models

/**
 * Representa as opções disponíveis no jogo
 */
enum class OpcaoJogo(val nome: String, val emoji: String) {
    PEDRA("Pedra", "🪨"),
    PAPEL("Papel", "📃"),
    TESOURA("Tesoura", "✂️");

    companion object {
        /**
         * Retorna uma opção aleatória
         */
        fun sortear(): OpcaoJogo {
            return values().random()
        }
    }
}

/**
 * Estado atual do jogo
 */
enum class EstadoJogo {
    PRONTO,
    SORTEANDO,
    RESULTADO
}
