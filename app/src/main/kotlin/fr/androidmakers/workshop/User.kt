package fr.androidmakers.workshop

import java.util.Date

data class User(
    val username: String,
    val email: String,
    val birthDate: Date,
    val accountType: AccountType,
    val preferences: Map<String, String>?
)