package com.nelsonquintanilla.news.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ArticlesApp(navHostController: NavHostController = rememberNavController()) {
    ArticlesNavHost(navController = navHostController)
}