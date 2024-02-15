package eu.batomobile.k_challenge.ui.feature.kahoot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import eu.batomobile.k_challenge.databinding.FragmentKahootBinding
import eu.batomobile.k_challenge.ui.feature.base.BaseFragmentWithVM

@AndroidEntryPoint
class KahootFragment :
    BaseFragmentWithVM<FragmentKahootBinding, KahootViewAction, KahootViewState, KahootViewModel>() {
    override val binding by lazy { FragmentKahootBinding.inflate(layoutInflater) }
    override fun getViewModelClass() = KahootViewModel::class.java
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.state.observe(viewLifecycleOwner, ::onState)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onState(viewState: KahootViewState) {
        when (viewState) {
            is KahootViewState.Loading -> {
                // Show loading
            }

            is KahootViewState.Complete -> {
                // Show kahoot
            }

            is KahootViewState.Error -> {
                // Show error
            }
        }
    }
}