package me.brisson.fruits.ui.fruit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.brisson.domain.repository.FruitMonthRepository
import me.brisson.fruits.ui.FruitsNavigationArgs
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor(
    private val fruitMonthRepository: FruitMonthRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val fruitId: Long
        get() {
            val id = savedStateHandle.get<Long>(FruitsNavigationArgs.FRUIT_ID_ARGS) ?: -1L
            if (id == -1L) {
                _uiState.update { it.copy(loading = false, missingFruitId = true) }
            }
            return id
        }

    private val _fruit = fruitMonthRepository.getFruitById(fruitId)
        .catch { t -> _uiState.update { it.copy(loading = false, fruitError = t) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    private val _uiState = MutableStateFlow(FruitUiState())
    val uiState: StateFlow<FruitUiState> = combine(_fruit, _uiState){ fruit, state ->
        state.copy(loading = false, fruit = fruit)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)


     fun favoriteFruit(favorite: Boolean) {
         uiState.value.fruit?.copy(isFavorite = favorite)?.let { fruit ->
             viewModelScope.launch(Dispatchers.IO) {
                 fruitMonthRepository.updateFruit(fruit)
             }
         }
     }
}