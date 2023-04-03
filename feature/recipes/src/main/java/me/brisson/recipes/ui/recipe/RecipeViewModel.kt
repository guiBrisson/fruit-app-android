package me.brisson.recipes.ui.recipe

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import me.brisson.domain.repository.RecipeRepository
import me.brisson.recipes.RecipeNavigationArgs
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    recipeRepository: RecipeRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val recipeId: Long
        get() {
            val id = savedStateHandle[RecipeNavigationArgs.RECIPE_ID_ARGS] ?: -1L
            if (id == -1L) {
                _uiState.update { it.copy(loading = false, missingRecipeId = true) }
            }
            return id
        }

    private val _recipe = recipeRepository.getRecipeById(recipeId)
        .catch { t -> _uiState.update { it.copy(loading = false, recipeError = t) } }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)

    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = combine(_recipe, _uiState) { recipe, state ->
        state.copy(loading = false, recipe = recipe)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)

    fun changeTab(tab: RecipeTab) {
        _uiState.update { it.copy(selectedTab = tab) }
    }

}
