package com.csarjz.yape.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.csarjz.yape.ui.features.detail.DetailScreen
import com.csarjz.yape.ui.features.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(route = Destination.Home.route) {
            HomeScreen(
                onNavigateToDetail = {
                    navController.navigate(
                        route = Destination.Detail.createVavRoute(recipeId = it),
                        navOptions = navOptions { launchSingleTop = true }
                    )
                }
            )
        }
        composable(route = Destination.Detail.route, arguments = Destination.Detail.args) {
            val recipeId = it.arguments?.getString("recipeId")
            requireNotNull(recipeId)
            DetailScreen(
                recipeId = recipeId,
                onNavigateToMap = {}
            )
        }
    }
}
