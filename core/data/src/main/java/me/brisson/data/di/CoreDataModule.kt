package me.brisson.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.brisson.data.GreetingsImpl
import me.brisson.data.SharedPreferences
import me.brisson.data.database.CoreDatabase
import me.brisson.data.database.dao.*
import me.brisson.data.database.repository.FruitMonthRepositoryImpl
import me.brisson.data.database.repository.RecipeRepositoryImpl
import me.brisson.domain.repository.FruitMonthRepository
import me.brisson.domain.repository.Greetings
import me.brisson.domain.repository.RecipeRepository
import me.brisson.domain.repository.SharedPref
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreDataModule {

    @Provides
    @Singleton
    fun providesSharePreferences(@ApplicationContext context: Context): SharedPref {
        return SharedPreferences(context)
    }

    @Provides
    @Singleton
    fun providesGreetings(@ApplicationContext context: Context): Greetings = GreetingsImpl(context)

    @Provides
    @Singleton
    fun providesCoreDatabase(@ApplicationContext context: Context): CoreDatabase {
        return Room.databaseBuilder(
            context,
            CoreDatabase::class.java, "Core"
        ).build()
    }

    @Provides
    fun providesFruitDao(coreDatabase: CoreDatabase): FruitDao = coreDatabase.fruitDao()

    @Provides
    fun providesMonthDao(coreDatabase: CoreDatabase): MonthDao = coreDatabase.monthDao()

    @Provides
    fun providesFruitMonthDao(coreDatabase: CoreDatabase): FruitMonthDao =
        coreDatabase.fruitMonthDao()

    @Provides
    fun providesRecipeDao(coreDatabase: CoreDatabase): RecipeDao = coreDatabase.recipeDao()

    @Provides
    fun providesFruitRecipeDao(coreDatabase: CoreDatabase): FruitRecipeDao =
        coreDatabase.fruitRecipeDao()

    @Provides
    @Singleton
    fun providesFruitMonthRepository(
        fruitDao: FruitDao,
        monthDao: MonthDao,
        fruitMonthDao: FruitMonthDao
    ): FruitMonthRepository = FruitMonthRepositoryImpl(fruitDao, monthDao, fruitMonthDao)


    @Provides
    @Singleton
    fun providesRecipeRepository(
        recipeDao: RecipeDao,
        fruitRecipeDao: FruitRecipeDao,
    ): RecipeRepository = RecipeRepositoryImpl(recipeDao, fruitRecipeDao)
}
