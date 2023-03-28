package me.brisson.fruits.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.brisson.domain.model.Fruit
import me.brisson.domain.repository.FruitMonthRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fruitMonthRepository: FruitMonthRepository
    ) : ViewModel() {

    private val _fruits: Flow<List<Fruit>> = fruitMonthRepository.getAllFruits()
        .catch { t -> _uiState.update { it.copy(fruitsLoading = false, fruitsError = t) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = combine(_fruits, _uiState) { fruits, state ->
        state.copy(fruitsLoading = false, fruits = fruits)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)


    fun updateFruit(fruit: Fruit) {
        viewModelScope.launch(Dispatchers.IO) {
            fruitMonthRepository.updateFruit(fruit)
        }
    }
}