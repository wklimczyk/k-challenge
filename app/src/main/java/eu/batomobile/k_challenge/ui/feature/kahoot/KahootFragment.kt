package eu.batomobile.k_challenge.ui.feature.kahoot

import dagger.hilt.android.AndroidEntryPoint
import eu.batomobile.k_challenge.databinding.FragmentKahootBinding
import eu.batomobile.k_challenge.ui.feature.base.BaseFragmentWithVM

@AndroidEntryPoint
class KahootFragment :
    BaseFragmentWithVM<FragmentKahootBinding, KahootViewAction, KahootViewState, KahootViewModel>() {
    override val binding by lazy { FragmentKahootBinding.inflate(layoutInflater) }
    override fun getViewModelClass() = KahootViewModel::class.java

    override fun onState(viewState: KahootViewState) {
        when (viewState) {
            is KahootViewState.Choices -> {
                // Show loading
            }

            is KahootViewState.Answers -> {
                // Show answers
            }

            is KahootViewState.Complete -> {
                // Show points
            }
        }
    }
}