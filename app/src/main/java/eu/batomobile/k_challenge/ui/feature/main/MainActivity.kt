package eu.batomobile.k_challenge.ui.feature.main

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import eu.batomobile.k_challenge.databinding.ActivityMainBinding
import eu.batomobile.k_challenge.ui.feature.base.BaseActivity

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewAction, MainViewState, MainViewModel>() {
    override fun getViewModelClass() = MainViewModel::class.java

    override val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onViewState(viewState: MainViewState) = when (viewState) {
        MainViewState.Loading -> Unit
        MainViewState.Error -> Unit
        is MainViewState.Complete -> Unit
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onViewAction(MainViewAction.LoadKahoot)
    }

}