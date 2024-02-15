package eu.batomobile.k_challenge.ui.feature.kahoot

import eu.batomobile.domain.entity.Question
import eu.batomobile.k_challenge.ui.base.BaseViewAction

sealed class KahootViewAction : BaseViewAction() {
    data class Init(val question: Question) : KahootViewAction()
    data object NextQuestion : KahootViewAction()
}