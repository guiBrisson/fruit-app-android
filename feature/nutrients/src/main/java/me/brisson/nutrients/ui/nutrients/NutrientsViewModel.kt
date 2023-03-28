package me.brisson.nutrients.ui.nutrients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.brisson.domain.repository.SharedPref
import me.brisson.nutrients.data.local.nutrients
import me.brisson.nutrients.domain.model.Nutrient
import me.brisson.nutrients.domain.repository.NutrientRepository
import javax.inject.Inject

@HiltViewModel
class NutrientsViewModel @Inject constructor(
    private val nutrientRepository: NutrientRepository,
    private val sharedPref: SharedPref
) : ViewModel() {

    private val _nutrients: Flow<List<Nutrient>> = nutrientRepository.getAllNutrients()
        .catch { t -> _uiState.update { it.copy(loading = false, error = t) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _uiState = MutableStateFlow(NutrientsUiState())
    val uiState: StateFlow<NutrientsUiState> = combine(_nutrients, _uiState) { nutrients, state ->
        state.copy(loading = false, nutrients = nutrients)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)

    fun insertNutrientsOnDb() {
        viewModelScope.launch(Dispatchers.IO) {
            nutrientRepository.insertNutrients(*nutrients.toTypedArray())
        }
    }

    fun saveCurrentNutrient(nutrientId: Long) {
        sharedPref.setSelectedNutrientId(nutrientId)
    }

    fun getLastOpenedNutrient() : Nutrient? {
        val nutrients = uiState.value.nutrients
        val lastNutrientId = sharedPref.selectedNutrientId()

        return nutrients.find { it.id == lastNutrientId }
    }
}
