package me.brisson.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.brisson.data.model.Month

@Entity(tableName = "month")
data class MonthEntity(
    @PrimaryKey @ColumnInfo(name = "monthName")
    val name: String,
    val number: Int,
) {
    fun toMonth(): Month {
        return Month(name, number)
    }
}
fun Month.toMonthEntity(): MonthEntity {
    return MonthEntity(this.name, this.number)
}
