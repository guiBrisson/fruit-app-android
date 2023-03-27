package me.brisson.domain.repository

interface SharedPref {
    fun setHasLoggedBefore(value: Boolean)
    fun hasLoggedBefore(): Boolean
    fun setSelectedNutrientId(id: Long)
    fun selectedNutrientId(): Long
}