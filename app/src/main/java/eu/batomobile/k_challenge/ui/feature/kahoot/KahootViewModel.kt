package eu.batomobile.k_challenge.ui.feature.kahoot

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.batomobile.domain.usecase.GetKahootUseCase
import eu.batomobile.k_challenge.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KahootViewModel @Inject constructor() : BaseViewModel<KahootViewAction, KahootViewState>() {
    override fun onViewAction(viewAction: KahootViewAction) = when (viewAction) {
        is KahootViewAction.Init -> init(viewAction)
        is KahootViewAction.ChoiceSelected -> onChoiceSelected(viewAction)
    }

    private fun onChoiceSelected(viewAction: KahootViewAction.ChoiceSelected) {
        state.value?.let { state ->
            if (state is KahootViewState.Choices) {
                viewModelScope.launch {
                    mutableState.value =
                        KahootViewState.Answers(viewAction.selectedChoice, state.question)
                }
            }
        }
    }

    private fun init(viewAction: KahootViewAction.Init) {
        viewModelScope.launch {
            mutableState.value =
                KahootViewState.Choices(
                    viewAction.question.time ?: DEFAULT_QUESTION_TIME_IN_MS,
                    viewAction.question
                )
        }
    }

    companion object {
        private const val DEFAULT_QUESTION_TIME_IN_MS = 30000L
    }
}