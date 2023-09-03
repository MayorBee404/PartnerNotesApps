package com.dbadeveloper.partnernotesapps.navigation

sealed class Screen (val route : String){
    data object Settings : Screen("settings")
    data object About : Screen("about")
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Register : Screen("register")
}