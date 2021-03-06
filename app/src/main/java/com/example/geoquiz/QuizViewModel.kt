package com.example.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0
    var isCheater = false

    private val questionBank = listOf(
        Question(R.string.question_africa, true, false),
        Question(R.string.question_machu, false, false),
        Question(R.string.question_new_zealand, false, false),
        Question(R.string.question_petra, true, false),
        Question(R.string.question_hawaii, true, false),
        Question(R.string.question_yellowstone, true, false),
        Question(R.string.question_LA, false, false)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    val currentQuestionRepeat: Boolean
        get() = questionBank[currentIndex].repeat

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = (currentIndex - 1) % questionBank.size
        if (currentIndex < 0) {
            currentIndex = questionBank.size - 1
        }
    }

    fun hasRepeated() {
        questionBank[currentIndex].repeat = true
    }
}