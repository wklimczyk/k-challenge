package eu.batomobile.k_challenge.ui.feature.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import eu.batomobile.k_challenge.ui.base.BaseViewAction
import eu.batomobile.k_challenge.ui.base.BaseViewModel
import eu.batomobile.k_challenge.ui.base.BaseViewState
import timber.log.Timber

abstract class BaseActivity<VB : ViewBinding, VA : BaseViewAction, VS : BaseViewState, VM : BaseViewModel<VA, VS>> :
    AppCompatActivity() {
    protected lateinit var viewModel: VM
    protected abstract fun getViewModelClass(): Class<VM>
    protected abstract val binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[getViewModelClass()]
        viewModel.state.observe(this, ::onViewState)
        Timber.v("onCreate ${javaClass.simpleName}")
        setContentView(binding.root)
    }

    abstract fun onViewState(viewState: VS)
}