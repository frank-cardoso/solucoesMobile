package br.satc.pedrapapeltesoura.utils

import android.content.Context
import android.media.MediaPlayer

/**
 * Classe responsável por gerenciar efeitos sonoros do jogo
 */
class AudioManager(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    /**
     * Toca um efeito sonoro durante o sorteio
     * TODO: Implementar com arquivo de áudio real
     */
    fun tocarEfeitoSorteio() {
        // Por enquanto, apenas um placeholder
        // Em uma implementação real, carregaria um arquivo de áudio
        // mediaPlayer = MediaPlayer.create(context, R.raw.sound_effect)
        // mediaPlayer?.start()
    }

    /**
     * Toca efeito sonoro do resultado
     */
    fun tocarEfeitoResultado() {
        // Placeholder para efeito de resultado
    }

    /**
     * Para todos os efeitos sonoros
     */
    fun pararTodos() {
        mediaPlayer?.let { player ->
            if (player.isPlaying) {
                player.stop()
            }
            player.release()
        }
        mediaPlayer = null
    }
}

/**
 * Extensão para simular vibração no dispositivo
 */
fun Context.vibrar(duracao: Long = 100) {
    // TODO: Implementar vibração usando Vibrator
    // val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    // vibrator.vibrate(duracao)
}
