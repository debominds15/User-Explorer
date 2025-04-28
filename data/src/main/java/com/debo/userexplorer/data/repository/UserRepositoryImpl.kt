package com.debo.userexplorer.data.repository

import com.debo.userexplorer.data.dto.toDomain
import com.debo.userexplorer.data.remote.UserService
import com.debo.userexplorer.domain.model.User
import com.debo.userexplorer.domain.repository.UserRepository


class UserRepositoryImpl(
    private val userService: UserService
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return userService.getUsers().map { it.toDomain() }
    }
}