package com.example.android.unscramble.ui.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel  : ViewModel() {
    private fun getNextWord() {
        currentWord = allWordsList.random()
    }
    init {
        Log.d("GameFragment", "gameViewModel created!")
    }
    private var score = 0
    private var currentWordCount = 0
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
}
