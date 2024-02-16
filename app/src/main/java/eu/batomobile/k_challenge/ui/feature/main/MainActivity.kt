package eu.batomobile.k_challenge.ui.feature.main

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import eu.batomobile.k_challenge.R
import eu.batomobile.k_challenge.databinding.ActivityMainBinding
import eu.batomobile.k_challenge.ui.feature.base.BaseActivity
import eu.batomobile.k_challenge.ui.feature.kahoot.KahootSharedViewModel
import eu.batomobile.k_challenge.ui.feature.loader.LoadingKahootFragmentDirections

@AndroidEntryPoint
class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewAction, MainViewState, MainViewModel>() {

    private val navController by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!.findNavController()
    }

    private val kahootSharedViewModel: KahootSharedViewModel by viewModels()
    override fun getViewModelClass() = MainViewModel::class.java

    override val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onViewState(viewState: MainViewState) = when (viewState) {
        MainViewState.Loading -> Unit //pop navigator to loading fragment
        MainViewState.Error -> onError()
        is MainViewState.Complete -> onComplete(viewState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onViewAction(MainViewAction.LoadKahoot)
    }

    private fun onComplete(data: MainViewState.Complete) {
        kahootSharedViewModel.setCurrentKahoot(data.kahoot)
        LoadingKahootFragmentDirections.actionShowKahoot(0)
            .let {
                navController.navigate(it)
            }
        // Show kahoot
    }

    private fun onError() {
        AlertDialog.Builder(this)
            .setTitle(R.string.general_error_title)
            .setMessage(R.string.general_error_message)
            .setPositiveButton(R.string.common_ok) { dialog, _ ->
                dialog.dismiss()
                viewModel.onViewAction(MainViewAction.LoadKahoot)
            }
            .show()
    }
}