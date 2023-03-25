package me.brisson.nutrients.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Nutrient(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "nutrientId")
    val id: Long = 0,
    val name: String,
    val tip: String? = null,
    val subTitle: String,
    val paragraphs: List<String>
)
