package com.debo.userexplorer.domain.model

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)