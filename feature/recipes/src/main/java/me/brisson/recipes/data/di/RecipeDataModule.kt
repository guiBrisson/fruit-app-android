package me.brisson.recipes.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.brisson.recipes.data.local.database.RecipeDao
import me.brisson.recipes.data.local.database.RecipeDatabase
import me.brisson.recipes.data.local.repository.RecipeRepositoryImpl
import me.brisson.recipes.domain.repository.RecipeRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RecipeDataModule {

    @Provides
    @Singleton
    fun providesRecipeRepository(recipeDao: RecipeDao): RecipeRepository {
        return RecipeRepositoryImpl(recipeDao)
    }

    @Provides
    fun providesRecipeDao(recipeDatabase: RecipeDatabase): RecipeDao {
        return recipeDatabase.recipeDao()
    }

    @Provides
    @Singleton
    fun providesRecipeDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return Room.databaseBuilder(
            context,
            RecipeDatabase::class.java, "recipe"
        ).build()
    }
}