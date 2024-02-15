package eu.batomobile.k_challenge.ui.feature.kahoot

import eu.batomobile.k_challenge.ui.base.BaseViewAction

sealed class KahootViewAction : BaseViewAction() {

    data object LoadKahoot : KahootViewAction()
    data object NextQuestion : KahootViewAction()
}