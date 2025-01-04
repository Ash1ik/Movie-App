package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreen.HomeScreen.name ) {
        // Add the screens here
        composable(MovieScreen.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(MovieScreen.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType})) {
            backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }

}