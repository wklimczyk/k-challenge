package eu.batomobile.k_challenge.ui.feature.question

import dagger.hilt.android.lifecycle.HiltViewModel
import eu.batomobile.k_challenge.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor() :
    BaseViewModel<QuestionViewAction, QuestionViewState>() {
    override fun onViewAction(viewAction: QuestionViewAction) = when (viewAction) {
        is QuestionViewAction.LoadQuestion -> {
            mutableState.value = QuestionViewState.Loading
        }

        QuestionViewAction.Complete -> {
//            mutableState.value = QuestionViewState.Complete
        }

        is QuestionViewAction.Answer -> TODO()
        QuestionViewAction.ShowAnswer -> TODO()
    }
}