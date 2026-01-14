package com.wzf.knowledgeflow.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wzf.knowledgeflow.AppDestinations
import com.wzf.knowledgeflow.ui.screens.DailyTasksScreen
import com.wzf.knowledgeflow.ui.screens.KnowledgeListScreen
import com.wzf.knowledgeflow.ui.screens.ReadLaterScreen
import com.wzf.knowledgeflow.ui.screens.SettingsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppDestinations.KNOWLEDGE_LIST.route,
        modifier = modifier
    ) {
        composable(AppDestinations.KNOWLEDGE_LIST.route) { KnowledgeListScreen() }
        composable(AppDestinations.DAILY_TASKS.route) { DailyTasksScreen() }
        composable(AppDestinations.READ_LATER.route) { ReadLaterScreen() }
        composable(AppDestinations.SETTINGS.route) { SettingsScreen() }
    }
}
