package com.nelsonquintanilla.news.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nelsonquintanilla.news.ui.articles.ArticlesDestination
import com.nelsonquintanilla.news.ui.articles.ArticlesScreen
import com.nelsonquintanilla.news.ui.articles.detail.ArticleDetailDestination
import com.nelsonquintanilla.news.ui.articles.detail.ArticleDetailScreen

@Composable
fun ArticlesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = ArticlesDestination.route,
        modifier = modifier
    ) {
        composable(route = ArticlesDestination.route) {
            ArticlesScreen(
                navigateToArticleDetail = {
                    navController.navigate("${ArticleDetailDestination.route}/$it")
                }
            )
        }
        composable(
            route = ArticleDetailDestination.routeWithArgs,
            arguments = listOf(navArgument(ArticleDetailDestination.ITEM_URL_ARG) {
                type = NavType.StringType
            })
        ) {
            ArticleDetailScreen(
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}