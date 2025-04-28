package com.debo.userexplorer.data.dto

import com.debo.userexplorer.domain.model.User


data class UserDto(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val company: String,
    val phone: String,
    val photo: String
)

fun UserDto.toDomain() = User(
    id = id,
    name = name,
    username = username,
    company = company,
    email = email,
    phone = phone,
    photo = photo
)
