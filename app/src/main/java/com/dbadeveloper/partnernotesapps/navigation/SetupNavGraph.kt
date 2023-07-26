package com.dbadeveloper.partnernotesapps.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dbadeveloper.partnernotesapps.ui.login.LoginScreen
import com.dbadeveloper.partnernotesapps.ui.register.Register
import com.dbadeveloper.partnernotesapps.ui.register.RegisterScreen
import com.dbadeveloper.partnernotesapps.ui.splash.AnimatedSplashScreen

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navHostController = navHostController)

        }
        composable(route = Screen.Login.route) {
            LoginScreen(navHostController = navHostController)
        }

        composable(route = Screen.Register.route) {
            RegisterScreen(navHostController = navHostController)
        }
    }
}
