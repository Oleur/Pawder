package com.example.androiddevchallenge.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.PetViewModel
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.pet.PetDetailScreen

@ExperimentalFoundationApi
@Composable
fun Navigation(petViewModel: PetViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(petViewModel, navController = navController)
        }

        composable("pet/{Id}",
            listOf(navArgument("Id") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getInt("Id")?.let { petId ->
                PetDetailScreen(petId, petViewModel)
            }
        }
    }
}
