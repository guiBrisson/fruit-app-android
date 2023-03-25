package me.brisson.nutrients.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.brisson.nutrients.domain.model.Nutrient


@Database(
    entities = [Nutrient::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class NutrientDatabase: RoomDatabase() {
    abstract fun nutrientDao() : NutrientDao
}