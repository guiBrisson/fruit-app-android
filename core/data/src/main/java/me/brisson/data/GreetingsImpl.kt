package me.brisson.data

import android.content.Context
import me.brisson.domain.repository.Greetings
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class GreetingsImpl(private val context: Context) : Greetings {

    override fun generateGreeting(username: String): String {
        val locale = Locale("pt", "BR")
        val dateFormat: DateFormat = SimpleDateFormat("k", locale)
        val hour = dateFormat.format(System.currentTimeMillis()).toInt()

        return fromTimeToGreeting(hour, username)
    }


    private fun fromTimeToGreeting(hour: Int, username: String): String {
        return when (hour) {
            in 0..5 -> context.getString(R.string.dawn_greeting, username)
            in 5..11 -> context.getString(R.string.morning_greeting, username)
            in 12..18 -> context.getString(R.string.afternoon_greeting, username)
            in 18..23 -> context.getString(R.string.evening_greeting, username)
            else -> ""
        }
    }

}