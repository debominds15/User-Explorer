package com.debo.userexplorer.domain.repository

import com.debo.userexplorer.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}