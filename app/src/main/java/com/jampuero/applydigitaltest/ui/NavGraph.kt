package com.jampuero.applydigitaltest.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jampuero.applydigitaltest.ui.detail.WebViewScreen
import com.jampuero.applydigitaltest.ui.list.PostListScreen
import com.jampuero.applydigitaltest.ui.list.PostViewModel

@Composable
fun NavGraph(viewModel: PostViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "list") {
        composable("list") { PostListScreen(viewModel, navController) }
        composable("webview/{url}") { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""
            WebViewScreen(url = url, onBackPressed = { navController.popBackStack() })
        }
    }
}