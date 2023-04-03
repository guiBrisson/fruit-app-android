package me.brisson.fruits.ui.presentation.crop_season

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import me.brisson.domain.model.Month
import me.brisson.domain.repository.FruitMonthRepository
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CropSeasonViewModel @Inject constructor(
    fruitMonthRepository: FruitMonthRepository
): ViewModel() {

    private val _months: StateFlow<List<Month>> = fruitMonthRepository.getAllMonths()
        .catch { t -> _uiState.update { it.copy(loadingMonths = false, monthsError = t) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _uiState = MutableStateFlow(CropSeasonUiState())
    val uiState: StateFlow<CropSeasonUiState> = combine(_months, _uiState) { months, state ->
        state.copy(loadingMonths = false, months = months)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)

    fun currentMonth() : Month? {
        val dateFormat: DateFormat = SimpleDateFormat("MM", Locale("pt", "BR"))
        val date = Date()
        return _months.value.find { it.number == dateFormat.format(date).toInt() }
    }

}
