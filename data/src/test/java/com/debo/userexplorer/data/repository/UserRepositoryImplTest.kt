package com.debo.userexplorer.data.repository

import com.debo.userexplorer.data.dto.UserDto
import com.debo.userexplorer.data.dto.toDomain
import com.debo.userexplorer.data.remote.UserService
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
class UserRepositoryImplTest {

    @Mock
    private lateinit var userService: UserService

    private lateinit var userRepository: UserRepository

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        userRepository = UserRepositoryImpl(userService)
    }

    @Test
    fun `test UserRepository fetches users correctly`() = runTest {
        val mockUsers = listOf(
            UserDto(
                id = 1,
                name = "John Doe",
                email = "johndoe@example.com",
                username = "johndoe",
                company = "company",
                phone = "9012821921",
                photo = ""
            ),
            UserDto(
                id = 2,
                name = "John Doe 2",
                email = "johndoe2@example.com",
                username = "johndoe2",
                company = "company",
                phone = "9012821921",
                photo = ""
            ),
        )

        `when`(userService.getUsers()).thenReturn(mockUsers)

        val users = mockUsers.map { it.toDomain() }

        val result = userRepository.getUsers()

        // Verify that the UserService was called
        verify(userService).getUsers()

        // Assert the result is as expected
        assertEquals(users, result)
    }
}