package com.debo.userexplorer.feature.userlist.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.debo.userexplorer.domain.model.User
import com.debo.userexplorer.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class UserListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var getUsersUseCase: GetUsersUseCase

    private lateinit var viewModel: UserListViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher) // Set Main dispatcher for tests
        viewModel = UserListViewModel(getUsersUseCase)
    }

    @Test
    fun `getUsers success updates state with user list`() = runTest {
        // Arrange
        val fakeUsers = listOf(
            User(
                id = 1,
                name = "John Doe",
                email = "johndoe@example.com",
                username = "johndoe",
                company = "company",
                phone = "9012821921",
                photo = ""
            ),
            User(
                id = 2,
                name = "John Doe 2",
                email = "johndoe2@example.com",
                username = "johndoe2",
                company = "company",
                phone = "9012821921",
                photo = ""
            ),

            )
        `when`(getUsersUseCase()).thenReturn(fakeUsers)

        // Act
        viewModel = UserListViewModel(getUsersUseCase)
        advanceUntilIdle()

        // Assert
        val state = viewModel.state.value
        assertFalse(state.isLoading)
        assertEquals(2, state.users.size)
        assertTrue(state.error.isEmpty())
    }

    @Test
    fun `getUsers failure updates state with error`() = runTest {
        // Arrange
        val errorMessage = "Network Error"
        `when`(getUsersUseCase()).thenThrow(RuntimeException(errorMessage))

        // Act
        viewModel = UserListViewModel(getUsersUseCase)
        advanceUntilIdle()

        // Assert
        val state = viewModel.state.value
        assertFalse(state.isLoading)
        assertTrue(state.users.isEmpty())
        assertEquals(errorMessage, state.error)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}