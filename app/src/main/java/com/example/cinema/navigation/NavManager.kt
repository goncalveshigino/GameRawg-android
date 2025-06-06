package com.example.cinema.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cinema.view.DetailView
import com.example.cinema.view.HomeView
import com.example.cinema.view.SearchGameView
import com.example.cinema.viewModel.GamesViewModel

@Composable
fun NavManager(viewModel: GamesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") {
            HomeView(viewModel, navController)
        }

        composable("DetailView/{id}", arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )) {
            val id = it.arguments?.getInt("id") ?: 0
            DetailView(viewModel, navController, id)
        }

        composable("SearchGameView") {
            SearchGameView(viewModel, navController)
        }
    }
}