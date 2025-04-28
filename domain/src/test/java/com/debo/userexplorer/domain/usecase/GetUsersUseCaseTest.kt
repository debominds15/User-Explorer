package com.debo.userexplorer.domain.usecase

import com.debo.userexplorer.domain.model.User
import com.debo.userexplorer.domain.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class GetUsersUseCaseTest {

    @Mock
    private lateinit var userRepository: UserRepository

    private lateinit var getUsersUseCase: GetUsersUseCase

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getUsersUseCase = GetUsersUseCase(userRepository)
    }

    @Test
    fun `test GetUsersUseCase returns a list of users`() = runTest {
        val mockUsers = listOf(
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

        // Mocking the repository call
        `when`(userRepository.getUsers()).thenReturn(mockUsers)

        val result = getUsersUseCase.invoke()

        // Verify that the repository's getUsers function was called once
        verify(userRepository).getUsers()

        // Assert the result is as expected
        assertEquals(mockUsers, result)
    }
}
