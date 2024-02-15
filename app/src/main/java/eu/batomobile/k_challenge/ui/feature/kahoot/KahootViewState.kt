package eu.batomobile.k_challenge.ui.feature.kahoot

import eu.batomobile.domain.entity.Question
import eu.batomobile.k_challenge.ui.base.BaseViewState

sealed class KahootViewState : BaseViewState() {
    data class Choices(val timeLeft: Int, val question: Question) : KahootViewState()
    data class Answers(val timeLeft: Int, val question: Question) : KahootViewState()
    data class Complete(val question: Question) : KahootViewState()
}