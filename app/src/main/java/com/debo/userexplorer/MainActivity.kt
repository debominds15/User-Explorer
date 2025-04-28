package com.debo.userexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.debo.userexplorer.feature.user.detail.ui.UserDetailScreen
import com.debo.userexplorer.feature.userlist.ui.UserListScreen
import com.debo.userexplorer.ui.theme.UserExplorerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserExplorerTheme{
                MainNavHost()
            }
        }
    }
}

@Composable
fun MainNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            UserListScreen(navController)
        }
        composable(
            "detail/{user}",
            arguments = listOf(
                navArgument("user") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val userJson = backStackEntry.arguments?.getString("user") ?: ""
            UserDetailScreen(userJson)
        }
    }
}