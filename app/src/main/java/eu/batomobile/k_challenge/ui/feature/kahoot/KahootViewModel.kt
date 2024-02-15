package eu.batomobile.k_challenge.ui.feature.kahoot

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.batomobile.domain.usecase.GetKahootUseCase
import eu.batomobile.k_challenge.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KahootViewModel @Inject constructor(
    private val kahootUseCase: GetKahootUseCase,
) : BaseViewModel<KahootViewAction, KahootViewState>() {
    override fun onViewAction(viewAction: KahootViewAction) = when (viewAction) {
        KahootViewAction.LoadKahoot -> loadKahoot()
        KahootViewAction.NextQuestion -> TODO("Not yet implemented")
    }

    private fun loadKahoot() {
        viewModelScope.launch {
            mutableState.value = KahootViewState.Loading
            try {
                val kahoot = kahootUseCase(Unit)
                mutableState.value = KahootViewState.Complete(kahoot)
            } catch (e: Exception) {
                mutableState.value = KahootViewState.Error
            }
        }
    }
}