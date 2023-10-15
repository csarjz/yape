package com.csarjz.yape.ui.main

import androidx.navigation.NavType
import androidx.navigation.navArgument

class NavArg(val name: String, val navType: NavType<*>)

@Suppress("ConvertObjectToDataObject")
sealed class Destination(val baseRoute: String, navArgs: List<NavArg> = emptyList()) {

    val route: String = listOf(baseRoute)
        .plus(navArgs.map { navArg -> "{${navArg.name}}" })
        .joinToString(separator = "/")

    val args = navArgs.map { navArg ->
        navArgument(name = navArg.name, builder = { navArg.navType })
    }

    object Home : Destination(baseRoute = "home")

    object Detail : Destination(
        baseRoute = "detail",
        navArgs = listOf(NavArg("recipeId", NavType.StringType))
    ) {
        fun createVavRoute(recipeId: String) = "$baseRoute/$recipeId"
    }

    object Map : Destination("map")
}
