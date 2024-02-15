package eu.batomobile.k_challenge.ui.feature.question

import eu.batomobile.domain.entity.Choice
import eu.batomobile.domain.entity.Question
import eu.batomobile.k_challenge.ui.base.BaseViewState

sealed class QuestionViewState : BaseViewState() {
    data object Loading : QuestionViewState()
    data class ShowAnswers(val answers: List<Choice>) : QuestionViewState()
    data class ShowResult(val answers: List<Choice>) : QuestionViewState()
    data class Complete(val question: Question) : QuestionViewState()
}