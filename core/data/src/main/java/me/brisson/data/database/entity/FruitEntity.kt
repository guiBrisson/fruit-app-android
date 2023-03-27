package me.brisson.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.brisson.domain.model.Fruit

@Entity(tableName = "fruit")
data class FruitEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "fruitId")
    val id: Long = 0,
    val name: String,
    val summary: String,
    val isFavorite: Boolean = false,
) {
    fun toFruit(): Fruit {
        return Fruit(id, name, summary, isFavorite)
    }
}

fun Fruit.toFruitEntity(): FruitEntity {
    return FruitEntity(id, name, summary, isFavorite)
}
