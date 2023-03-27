package me.brisson.nutrients.ui.nutrients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.brisson.nutrients.domain.model.Nutrient
import me.brisson.nutrients.domain.repository.NutrientRepository
import javax.inject.Inject

@HiltViewModel
class NutrientsViewModel @Inject constructor(nutrientRepository: NutrientRepository) : ViewModel() {

    private val _nutrients: Flow<List<Nutrient>> = nutrientRepository.getAllNutrients()
        .catch { t -> _uiState.update { it.copy(loading = false, error = t) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _uiState = MutableStateFlow(NutrientsUiState())
    val uiState: StateFlow<NutrientsUiState> = combine(_nutrients, _uiState) { nutrients, state ->
        state.copy(loading = false, nutrients = nutrients)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)

    fun findNextNutrient(nutrient: Nutrient) {
        viewModelScope.launch {
            val nutrients = uiState.value.nutrients
            if (nutrients.isNotEmpty()){
                val nextNutrientIndex = nutrients.indexOf(nutrient) + 1
                if (nextNutrientIndex > nutrients.lastIndex) {
                    _uiState.update { it.copy(nextNutrient = null) }
                } else{
                    _uiState.update { it.copy(nextNutrient = nutrients[nextNutrientIndex]) }
                }
            }
        }
    }

}