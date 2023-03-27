package me.brisson.fruits.ui.crop_season

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
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

    init {
        val months = listOf(
            Month(name = "Janeiro", number = 1),
            Month(name = "Fevereiro", number = 2),
            Month(name = "Março", number = 3),
            Month(name = "Abril", number = 4),
            Month(name = "Maio", number = 5),
            Month(name = "Junho", number = 6),
            Month(name = "Julho", number = 7),
            Month(name = "Agosto", number = 8),
            Month(name = "Setembro", number = 9),
            Month(name = "Outrubro", number = 10),
            Month(name = "Novembro", number = 11),
            Month(name = "Dezembro", number = 12),
        )
        viewModelScope.launch {
            months.forEach {
                fruitMonthRepository.addMonth(it)
            }
        }
    }

}
