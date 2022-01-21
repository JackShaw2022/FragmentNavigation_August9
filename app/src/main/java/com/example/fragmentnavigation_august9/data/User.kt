package com.example.fragmentnavigation_august9.data

data class User(
    val userName: UserName,
    val userEmail: UserEmail,
    val userPassword: UserPassword
)
data class UserName(
    val firstName: String,
    val lastName: String,
)
data class UserEmail(
    val email: String
)
data class UserPassword(
    val password: String
)