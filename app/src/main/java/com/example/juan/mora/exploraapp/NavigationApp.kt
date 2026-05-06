package com.example.juan.mora.exploraapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.juan.mora.exploraapp.ui.elements.AddTouristicPlaceScreen
import com.example.juan.mora.exploraapp.ui.elements.HomeScreen
import com.example.juan.mora.exploraapp.ui.elements.LoginScreen
import com.example.juan.mora.exploraapp.ui.elements.RegisterScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


@Composable
fun NavigationApp() {
    val myNavController = rememberNavController()
    val auth = Firebase.auth
    val currentUser = auth.currentUser


    val myStartDestination = if (currentUser != null) "home" else "login"

    NavHost(
        navController = myNavController,

        startDestination = myStartDestination,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = "login") {
            LoginScreen(
                // Deja solo uno para evitar confusiones
                onLoginSuccess = {
                    myNavController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                },
            ) {
                myNavController.navigate("register")
            }
        }

        composable(route = "register") {
            RegisterScreen(
                onRegisterSuccess = {

                    myNavController.navigate("home") {
                        popUpTo("register") { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    myNavController.navigate("login")
                },
                onBackClick = {
                    myNavController.popBackStack()
                }
            )
        }

        composable(route = "home") {
            HomeScreen(
                navController = myNavController,
                onClickLogout = {
                    auth.signOut()

                    myNavController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
        composable  (route="add_touristic_place"){
            AddTouristicPlaceScreen (navController = myNavController)
        }

    }

}