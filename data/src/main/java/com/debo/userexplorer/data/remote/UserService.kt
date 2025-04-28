package com.debo.userexplorer.data.remote

import com.debo.userexplorer.data.dto.UserDto
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers(): List<UserDto>
}