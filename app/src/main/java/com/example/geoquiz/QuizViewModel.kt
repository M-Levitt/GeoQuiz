package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0

    private val questionBank = listOf(
        Question(R.string.question_africa, true),
        Question(R.string.question_machu, false),
        Question(R.string.question_new_zealand, false),
        Question(R.string.question_petra, true),
        Question(R.string.question_hawaii, true),
        Question(R.string.question_yellowstone, true),
        Question(R.string.question_LA, false)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = (currentIndex - 1) % questionBank.size
        if (currentIndex < 0) {
            currentIndex = questionBank.size - 1
        }
    }
}