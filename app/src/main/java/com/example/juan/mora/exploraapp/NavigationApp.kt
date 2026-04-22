package com.example.juan.mora.exploraapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationApp (){
    val myNavController = rememberNavController()
    val myStartDestination: String = "login"

    NavHost(
        navController = myNavController,
        startDestination = "Login",
        modifier = Modifier.fillMaxSize()

    ) {
        composable (route = "login"){
            LoginScreen(onLoginSuccess = {}, onNavigateToRegister = {})
            myNavController.navigate("register")


        }
        composable (route = "register"){
            RegisterScreen(onRegisterSuccess = {}, onNavigateToLogin = {},
                onBackClick = {})
            myNavController.navigate("login")
        }
    }
}