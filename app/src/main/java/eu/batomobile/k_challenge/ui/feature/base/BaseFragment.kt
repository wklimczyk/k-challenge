package eu.batomobile.k_challenge.ui.feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import timber.log.Timber

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected abstract val binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.v("onCreateView ${javaClass.simpleName}")
        return binding.root
    }
}