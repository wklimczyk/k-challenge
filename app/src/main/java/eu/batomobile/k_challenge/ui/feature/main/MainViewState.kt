package eu.batomobile.k_challenge.ui.feature.main

import eu.batomobile.domain.entity.Kahoot
import eu.batomobile.k_challenge.ui.base.BaseViewState

sealed class MainViewState : BaseViewState() {
    data object Loading : MainViewState()
    data object Error : MainViewState()
    data class Complete(val kahoot: Kahoot) : MainViewState()
}