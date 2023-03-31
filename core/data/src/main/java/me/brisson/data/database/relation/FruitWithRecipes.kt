package me.brisson.data.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import me.brisson.data.database.entity.FruitEntity
import me.brisson.data.database.entity.RecipeEntity
import me.brisson.domain.model.Recipe

data class FruitWithRecipes(
    @Embedded val fruitEntity: FruitEntity,
    @Relation(
        parentColumn = "fruitId",
        entityColumn = "recipeId",
        associateBy = Junction(FruitRecipeCrossRef::class)
    )
    val recipesEntity: List<RecipeEntity>
) {
    fun toRecipes(): List<Recipe> {
        return recipesEntity.map { it.toRecipe() }
    }
}