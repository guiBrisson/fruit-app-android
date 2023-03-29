package me.brisson.data.database

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun convertFromStringToStringList(value: String): List<String> {
        return value.split("\n\n")
    }

    @TypeConverter
    fun convertFromListStringToString(value: List<String>): String {
        return value.joinToString(separator = "\n\n")
    }
}