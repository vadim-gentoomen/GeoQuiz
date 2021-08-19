package ru.krtech.android.test

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    var currentIndex = 0
    var isCheater = false

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToPrevious() {
        Log.d(TAG, "moveToPrevious called")
        if (currentIndex > 0) {
            currentIndex -= 1
        } else {
            currentIndex = questionBank.size - 1
        }
    }

    fun moveToNext() {
        Log.d(TAG, "moveToNext called")
        currentIndex = (currentIndex + 1) % questionBank.size
    }

}