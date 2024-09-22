package gallegos.david.quizapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//Se esta creando una etiqueta
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizzViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val bancoPregunta = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_asia, false),
        Question(R.string.question_africa, false),
    )
    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    private var currentIndex:Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY)?:0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = bancoPregunta[currentIndex].answer

    val currentQuestionText: Int
    get() = bancoPregunta[currentIndex].textResId
    fun moveToNext() {
        currentIndex= (currentIndex + 1) % bancoPregunta.size
    }
    fun moveToBack() {
        currentIndex = if (currentIndex == 0) {
            bancoPregunta.size -1
        } else {
            (currentIndex-1) % bancoPregunta.size
        }
    }
}