package me.brisson.domain.repository

interface Greetings {
    fun generateGreeting(username: String): String
}