package me.brisson.recipes.ui.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.brisson.domain.repository.RecipeRepository
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()

    init {
        getAllRecipes()
    }

    fun changeTab(tab: RecipeTab) {
        _uiState.update { it.copy(selectedTab = tab) }
    }

    //todo: change to get by id
    private fun getAllRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            recipeRepository.getAllRecipes().catch {throwable ->
                _uiState.update { it.copy(loading = false, recipeError = throwable) }
            }.collect { recipes ->
                if (recipes.isNotEmpty()) {
                    _uiState.update { it.copy(loading = false, recipe = recipes.first()) }
                }
            }
        }
    }
}