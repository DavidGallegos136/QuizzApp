package gallegos.david.quizapp

import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test

class QuizzViewModelTest {
    @Test
    fun providesExpectedQuestionText() {
        val savedStateHandle = SavedStateHandle()
        val quizzViewModel = QuizzViewModel(savedStateHandle)
        assertEquals(R.string.question_australia, quizzViewModel.currentQuestionText)

    }

    @Test
    fun wrapsAroundQuestionBank(){
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 2))
        val quizzViewModel = QuizzViewModel(savedStateHandle)
        assertEquals(R.string.question_africa, quizzViewModel.currentQuestionText)
        quizzViewModel.moveToNext()
        assertEquals(R.string.question_australia, quizzViewModel.currentQuestionText)
    }
}