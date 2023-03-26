package me.brisson.data.database.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import me.brisson.data.database.entity.MonthEntity

@Dao
interface MonthDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMonth(fruit: MonthEntity)

    @Query("SELECT * FROM month")
    fun getAllMonths(): Flow<List<MonthEntity>>

    @Query("SELECT * FROM month WHERE monthName LIKE :name")
    fun getMonthByName(name: String): Flow<MonthEntity>

    @Delete
    suspend fun deleteMonth(vararg fruit: MonthEntity)

    @Query("SELECT EXISTS(SELECT * FROM month WHERE monthName LIKE :name)")
    fun doesMonthExists(name: String): Boolean
}
