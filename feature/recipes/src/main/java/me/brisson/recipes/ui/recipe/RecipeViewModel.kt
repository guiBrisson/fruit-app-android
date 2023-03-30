package me.brisson.recipes.ui.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.brisson.recipes.data.local.recipeTest
import me.brisson.recipes.domain.repository.RecipeRepository
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState: StateFlow<RecipeUiState> = _uiState.asStateFlow()

    init {
        insertRecipeTest()
        getAllRecipes()
    }


    //todo: remover essas duas funções quando tiver a relação de fruta-receita
    private fun insertRecipeTest() {
        viewModelScope.launch(Dispatchers.IO) {
            recipeRepository.insertRecipe(recipeTest)
        }
    }

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