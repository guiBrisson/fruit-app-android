package me.brisson.recipes.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.brisson.recipes.data.local.entity.IngredientEntity
import me.brisson.recipes.data.local.entity.RecipeEntity

@Database(
    entities = [
        RecipeEntity::class,
        IngredientEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}