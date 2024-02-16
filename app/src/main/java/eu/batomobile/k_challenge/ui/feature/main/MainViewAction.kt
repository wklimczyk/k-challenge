package eu.batomobile.k_challenge.ui.feature.main

import eu.batomobile.k_challenge.ui.base.BaseViewAction

sealed class MainViewAction : BaseViewAction() {
    data object LoadKahoot : MainViewAction()
}