package eu.batomobile.k_challenge.ui.feature.kahoot

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.batomobile.domain.entity.Kahoot
import javax.inject.Inject

@HiltViewModel
class KahootSharedViewModel @Inject constructor() : ViewModel() {
    private var _currentKahoot: Kahoot? = null

    fun getCurrentKahoot() = _currentKahoot
    fun setCurrentKahoot(kahoot: Kahoot) {
        _currentKahoot = kahoot
    }
}