package eu.batomobile.k_challenge.ui.feature.kahoot

import eu.batomobile.domain.entity.Choice
import eu.batomobile.domain.entity.Question
import eu.batomobile.k_challenge.ui.base.BaseViewState

sealed class KahootViewState : BaseViewState() {
    data class Choices(val time: Long, val question: Question) : KahootViewState()
    data class Answers(val selectedChoice: Choice?, val question: Question) : KahootViewState()
    data class Complete(val question: Question) : KahootViewState()
}