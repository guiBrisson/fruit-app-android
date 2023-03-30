package me.brisson.recipes.data.local.database

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun convertFromStringToStringList(value: String?): List<String> {
        return value?.split("\n\n") ?: emptyList()
    }

    @TypeConverter
    fun convertFromListStringToString(value: List<String>?): String {
        return value?.joinToString(separator = "\n\n") ?: ""
    }
}