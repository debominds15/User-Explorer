package com.debo.userexplorer.feature.userlist.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.debo.userexplorer.domain.model.UserListState
import com.debo.userexplorer.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val users = getUsersUseCase()
                _state.value = UserListState(users = users, isLoading = false)
            } catch (e: Exception) {
                _state.value = UserListState(
                    error = e.localizedMessage ?: "An unexpected error occurred",
                    isLoading = false
                )
            }
        }
    }
}