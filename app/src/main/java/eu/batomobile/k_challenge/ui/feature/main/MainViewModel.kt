package eu.batomobile.k_challenge.ui.feature.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.batomobile.domain.usecase.GetKahootUseCase
import eu.batomobile.k_challenge.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getKahootUseCase: GetKahootUseCase,
) : BaseViewModel<MainViewAction, MainViewState>() {
    override fun onViewAction(viewAction: MainViewAction) = when (viewAction) {
        MainViewAction.LoadKahoot -> loadKahoot()
    }

    private fun loadKahoot() {
        viewModelScope.launch {
            mutableState.value = MainViewState.Loading
            try {
                val kahoot = getKahootUseCase(Unit)
                mutableState.value = MainViewState.Complete(kahoot)
            } catch (e: Exception) {
                mutableState.value = MainViewState.Error
            }
        }
    }
}