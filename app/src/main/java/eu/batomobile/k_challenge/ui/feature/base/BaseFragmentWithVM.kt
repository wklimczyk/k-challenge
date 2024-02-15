package eu.batomobile.k_challenge.ui.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import eu.batomobile.k_challenge.ui.base.BaseViewAction
import eu.batomobile.k_challenge.ui.base.BaseViewModel
import eu.batomobile.k_challenge.ui.base.BaseViewState
import timber.log.Timber


abstract class BaseFragmentWithVM<VB : ViewBinding, VA : BaseViewAction, VS : BaseViewState, VM : BaseViewModel<VA, VS>> :
    BaseFragment<VB>() {

    protected lateinit var viewModel: VM
    protected abstract fun getViewModelClass(): Class<VM>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[getViewModelClass()]
        viewModel.state.observe(viewLifecycleOwner, ::onState)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected abstract fun onState(viewState: VS)
}