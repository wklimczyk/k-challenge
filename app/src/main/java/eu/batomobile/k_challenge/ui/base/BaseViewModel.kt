package eu.batomobile.k_challenge.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<VA : BaseViewAction, VS : BaseViewState> : ViewModel() {
    val state: LiveData<VS> get() = mutableState
    protected val mutableState = MutableLiveData<VS>()
    abstract fun onViewAction(viewAction: VA)
}