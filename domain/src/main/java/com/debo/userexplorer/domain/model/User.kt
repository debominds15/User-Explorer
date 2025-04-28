package com.debo.userexplorer.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val company: String,
    val phone: String,
    val photo: String
)
