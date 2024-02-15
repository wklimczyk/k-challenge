package eu.batomobile.k_challenge.ui.feature.kahoot

import eu.batomobile.domain.entity.Kahoot
import eu.batomobile.k_challenge.ui.base.BaseViewState

sealed class KahootViewState : BaseViewState() {
    data object Loading : KahootViewState()
    data object Error : KahootViewState()
    data class Complete(val kahoot: Kahoot) : KahootViewState()
}