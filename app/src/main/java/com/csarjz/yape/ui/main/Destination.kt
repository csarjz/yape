package com.csarjz.yape.ui.main

import androidx.navigation.NavType
import androidx.navigation.navArgument

class NavArg(val name: String, val navType: NavType<*>)

@Suppress("ConvertObjectToDataObject")
sealed class Destination(baseRoute: String, navArgs: List<NavArg> = emptyList()) {

    val route: String = listOf(baseRoute)
        .plus(navArgs.map { navArg -> "{${navArg.name}}" })
        .joinToString(separator = "/")

    val args = navArgs.map { navArg ->
        navArgument(name = navArg.name, builder = { navArg.navType })
    }

    object Home : Destination("home")
    object Detail : Destination("detail")
    object Map : Destination("map")
}
