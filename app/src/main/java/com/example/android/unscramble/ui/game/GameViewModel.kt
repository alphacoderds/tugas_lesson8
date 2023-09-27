package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel  : ViewModel() {
    private var score = 0
    val score: Int
        get() = _score
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"
    private lateinit var _currentScrambledWord: String
    val currentScrambledWord: String
        get() = _currentScrambledWord
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    init {
        Log.d("GameFragment", "gameViewModel created!")
        getNextWord()
    }

    override fun onCleared() {
        MaterialAlertDialogBuilder(requireContext())
    }
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }

    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord).equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
        fun nextWord(): Boolean {
            return if (currentWordCount < MAX_NO_OF_WORDS) {
                getNextWord()
                true
            } else false
        }
    }
}
