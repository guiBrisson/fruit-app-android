package me.brisson.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.brisson.data.database.dao.*
import me.brisson.data.database.relation.FruitMonthCrossRef
import me.brisson.data.database.entity.FruitEntity
import me.brisson.data.database.entity.IngredientEntity
import me.brisson.data.database.entity.MonthEntity
import me.brisson.data.database.entity.RecipeEntity
import me.brisson.data.database.relation.FruitRecipeCrossRef

@Database(
    entities = [
        FruitEntity::class,
        MonthEntity::class,
        FruitMonthCrossRef::class,
        RecipeEntity::class,
        IngredientEntity::class,
        FruitRecipeCrossRef::class,
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun fruitDao(): FruitDao
    abstract fun monthDao(): MonthDao
    abstract fun fruitMonthDao(): FruitMonthDao
    abstract fun recipeDao(): RecipeDao
    abstract fun fruitRecipeDao(): FruitRecipeDao
}