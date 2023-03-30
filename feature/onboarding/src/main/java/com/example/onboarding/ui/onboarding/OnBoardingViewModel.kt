package com.example.onboarding.ui.onboarding


import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import me.brisson.domain.repository.SharedPref
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val sharedPref: SharedPref) : ViewModel() {
    private val _uiState = MutableStateFlow(OnBoardingUiState())
    val uiState: StateFlow<OnBoardingUiState> = _uiState.asStateFlow()

    fun moveToSecondComponent() {
        _uiState.update {
            it.copy(component = OnBoardingComponent.SECOND_COMPONENT)
        }
    }

    fun setUserName(userName: String) {
        sharedPref.setUserName(userName)
    }

}