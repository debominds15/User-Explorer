package com.debo.userexplorer.data.di

import com.debo.userexplorer.data.remote.UserService
import com.debo.userexplorer.data.repository.UserRepositoryImpl
import com.debo.userexplorer.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideUserRepository(userService: UserService): UserRepository {
        return UserRepositoryImpl(userService)
    }
}