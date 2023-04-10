package me.brisson.onboard.ui.loading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.brisson.domain.*
import me.brisson.domain.repository.FruitMonthRepository
import me.brisson.domain.repository.RecipeRepository
import me.brisson.domain.repository.SharedPref
import javax.inject.Inject

@HiltViewModel
class LoadingViewModel @Inject constructor(
    private val sharedPref: SharedPref,
    private val recipeRepository: RecipeRepository,
    private val fruitMonthRepository: FruitMonthRepository
) : ViewModel() {
    private fun insertMockedData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (!sharedPref.hasLoggedBefore()) {
                fruitMonthRepository.addMonth(*months.toTypedArray())
                fruits.forEach { fruit -> fruitMonthRepository.addFruit(fruit) }
                recipes.forEach { recipe -> recipeRepository.insertRecipe(recipe) }
                relationFruitRecipe.forEach{ pair -> recipeRepository.insertRecipeFruitRelation(pair.first, pair.second) }
            }
        }
    }
}