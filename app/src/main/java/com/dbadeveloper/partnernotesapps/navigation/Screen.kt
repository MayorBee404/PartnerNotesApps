package com.dbadeveloper.partnernotesapps.navigation

sealed class Screen (val route : String){
    object Settings : Screen("settings")
    object About : Screen("about")
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Register : Screen("register")
}