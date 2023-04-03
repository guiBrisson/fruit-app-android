package me.brisson.nutrients.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.brisson.nutrients.data.local.database.NutrientDao
import me.brisson.nutrients.data.local.database.NutrientDatabase
import me.brisson.nutrients.data.local.repository.NutrientRepositoryImpl
import me.brisson.nutrients.domain.repository.NutrientRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NutrientDataModule {

    @Provides
    @Singleton
    fun providesNutrientsRepository(nutrientDao: NutrientDao): NutrientRepository {
        return  NutrientRepositoryImpl(nutrientDao)
    }

    @Provides
    fun providesNutrientDao(nutrientDatabase: NutrientDatabase) : NutrientDao {
        return nutrientDatabase.nutrientDao()
    }

    @Provides
    @Singleton
    fun providesNutrientDatabase(@ApplicationContext context: Context) : NutrientDatabase {
        return Room.databaseBuilder(
            context,
            NutrientDatabase::class.java,  "nutrient"
        ).build()
    }

}