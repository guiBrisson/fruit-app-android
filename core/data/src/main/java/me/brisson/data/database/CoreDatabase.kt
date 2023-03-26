package me.brisson.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import me.brisson.data.database.dao.FruitDao
import me.brisson.data.database.dao.FruitMonthDao
import me.brisson.data.database.dao.MonthDao
import me.brisson.data.database.relation.FruitMonthCrossRef
import me.brisson.data.database.entity.FruitEntity
import me.brisson.data.database.entity.MonthEntity

@Database(
    entities = [
        FruitEntity::class,
        MonthEntity::class,
        FruitMonthCrossRef::class
    ],
    version = 1
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun fruitDao(): FruitDao
    abstract fun monthDao(): MonthDao
    abstract fun fruitMonthDao(): FruitMonthDao
}