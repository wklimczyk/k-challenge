package eu.batomobile.k_challenge.ui.feature.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import eu.batomobile.k_challenge.databinding.FragmentQuestionBinding
import eu.batomobile.k_challenge.ui.feature.base.BaseFragmentWithVM

@AndroidEntryPoint
class QuestionFragment :
    BaseFragmentWithVM<FragmentQuestionBinding, QuestionViewAction, QuestionViewState, QuestionViewModel>() {
    override val binding by lazy { FragmentQuestionBinding.inflate(layoutInflater) }
    override fun getViewModelClass() = QuestionViewModel::class.java
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.state.observe(viewLifecycleOwner, ::onState)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onState(viewState: QuestionViewState) {
        when (viewState) {
            is QuestionViewState.Loading -> {
                // Show loading
            }

            is QuestionViewState.Complete -> {
                // Show question
            }

            is QuestionViewState.ShowAnswers -> TODO()
            is QuestionViewState.ShowResult -> TODO()
        }
    }
}