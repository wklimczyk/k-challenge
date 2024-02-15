package eu.batomobile.k_challenge.ui.feature.question

import eu.batomobile.domain.entity.Choice
import eu.batomobile.domain.entity.Question
import eu.batomobile.k_challenge.ui.base.BaseViewAction

sealed class QuestionViewAction : BaseViewAction() {

    data class LoadQuestion(val question: Question) : QuestionViewAction()
    data class Answer(val choice: Choice) : QuestionViewAction()
    data object ShowAnswer : QuestionViewAction()
    data object Complete : QuestionViewAction()
}