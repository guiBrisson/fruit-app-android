package me.brisson.nutrients.ui.nutrients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutrientsViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(NutrientsUiState())
    val uiState: StateFlow<NutrientsUiState> = _uiState.asStateFlow()

    init {
       viewModelScope.launch {
           delay(4000)
           _uiState.update { it.copy(loading = false) }
       }
    }

}