package com.example.aula03

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class TreasureHuntUiState(
    val elapsedSeconds: Int = 0,
    val isTimerRunning: Boolean = false,
    val solvedClues: Set<Int> = emptySet(),
    val hasFoundTreasure: Boolean = false
)

class TreasureHuntViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TreasureHuntUiState())
    val uiState: StateFlow<TreasureHuntUiState> = _uiState.asStateFlow()

    var clueAnswers by mutableStateOf(mapOf(1 to "", 2 to "", 3 to ""))
        private set

    val correctAnswers: Map<Int, String> = mapOf(
        1 to "sombra",
        2 to "fogo",
        3 to "chave"
    )

    private var timerJob: Job? = null

    fun startHunt() {
        resetGameState()
        startTimer()
    }

    fun updateClueAnswer(clueId: Int, answer: String) {
        clueAnswers = clueAnswers + (clueId to answer)
    }

    fun validateClue(clueId: Int): Boolean {
        val typedAnswer = clueAnswers[clueId].orEmpty().trim()
        val expectedAnswer = correctAnswers[clueId].orEmpty().trim()
        val isCorrect = typedAnswer.equals(expectedAnswer, ignoreCase = true)

        if (isCorrect) {
            _uiState.update { current ->
                current.copy(solvedClues = current.solvedClues + clueId)
            }
        }

        return isCorrect
    }

    fun onTreasureReached() {
        stopTimer()
        _uiState.update { it.copy(hasFoundTreasure = true) }
    }

    fun restartHunt() {
        resetGameState()
    }

    fun formatElapsedTime(): String {
        val total = uiState.value.elapsedSeconds
        val minutes = total / 60
        val seconds = total % 60
        return "%02d:%02d".format(minutes, seconds)
    }

    private fun startTimer() {
        if (timerJob?.isActive == true) return

        _uiState.update { it.copy(isTimerRunning = true) }
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1_000)
                _uiState.update { current ->
                    current.copy(elapsedSeconds = current.elapsedSeconds + 1)
                }
            }
        }
    }

    private fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
        _uiState.update { it.copy(isTimerRunning = false) }
    }

    private fun resetGameState() {
        stopTimer()
        clueAnswers = mapOf(1 to "", 2 to "", 3 to "")
        _uiState.value = TreasureHuntUiState()
    }

    override fun onCleared() {
        stopTimer()
        super.onCleared()
    }
}

