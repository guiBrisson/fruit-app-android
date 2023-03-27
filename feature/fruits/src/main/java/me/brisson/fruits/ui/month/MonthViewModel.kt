package me.brisson.fruits.ui.month

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import me.brisson.domain.repository.FruitMonthRepository
import me.brisson.fruits.ui.FruitsNavigationArgs
import javax.inject.Inject

@HiltViewModel
class MonthViewModel @Inject constructor(
    fruitMonthRepository: FruitMonthRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val monthName: String
        get() {
            val name = savedStateHandle.get<String>(FruitsNavigationArgs.MONTH_NAME_ARGS)
            if (name.isNullOrEmpty()){
                _uiState.update { it.copy(loading = false, nameArgError = true) }
            }
            return name ?: ""
    }

    private val _month = fruitMonthRepository.getMonthByName(monthName)
        .catch { t -> _uiState.update { it.copy(loading = false, monthError = t) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    private val _uiState = MutableStateFlow(MonthUiState())
    val uiState: StateFlow<MonthUiState> = combine(_month, _uiState) { month, state ->
        state.copy(loading = false, month = month)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)

}
