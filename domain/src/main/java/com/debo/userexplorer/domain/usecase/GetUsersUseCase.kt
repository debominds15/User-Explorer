package com.debo.userexplorer.domain.usecase

import com.debo.userexplorer.domain.model.User
import com.debo.userexplorer.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: UserRepository) {
    suspend operator fun invoke(): List<User> {
        return repository.getUsers()
    }
}