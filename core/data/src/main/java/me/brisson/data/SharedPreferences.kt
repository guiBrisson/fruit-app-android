package me.brisson.data

import android.content.Context
import me.brisson.domain.repository.SharedPref

class SharedPreferences(context: Context) :SharedPref {
    private val sharedPref = context.getSharedPreferences(userSetting, Context.MODE_PRIVATE)

    override fun setHasLoggedBefore(value: Boolean) = putBoolean(hasLoggedBefore, value)
    override fun hasLoggedBefore(): Boolean = getBoolean(hasLoggedBefore)

    override fun setSelectedNutrientId(id: Long) = putLong(selectedNutrientId, id)
    override fun selectedNutrientId(): Long = getLong(selectedNutrientId)


    // private getters and setters functions

    private fun putString(key: String, value: String) {
        sharedPref.edit().putString(key, value).apply()
    }

    private fun getString(key: String): String? = sharedPref.getString(key, "")

    private fun putBoolean(key: String, value: Boolean) {
        sharedPref.edit().putBoolean(key, value).apply()
    }

    private fun getBoolean(key: String): Boolean = sharedPref.getBoolean(key, false)

    private fun putLong(key: String, value: Long) {
        sharedPref.edit().putLong(key, value).apply()
    }

    private fun getLong(key: String): Long = sharedPref.getLong(key, -1)

    companion object {
        private const val userSetting = "user_settings"
        private const val hasLoggedBefore = "logged_before"
        private const val selectedNutrientId = "selected_nutrient_id"
    }

}
