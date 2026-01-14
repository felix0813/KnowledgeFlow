package com.wzf.knowledgeflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.wzf.knowledgeflow.ui.navigation.AppNavHost
import com.wzf.knowledgeflow.ui.theme.KnowledgeFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KnowledgeFlowTheme {
                KnowledgeFlowApp()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun KnowledgeFlowApp() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route ?: AppDestinations.KNOWLEDGE_LIST.route

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it.route == currentRoute,
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.navigate(it.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo(AppDestinations.KNOWLEDGE_LIST.route) { saveState = true }
                            }
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

enum class AppDestinations(
    val route: String,
    val label: String,
    val icon: ImageVector,
) {
    KNOWLEDGE_LIST("knowledge", "Knowledge", Icons.AutoMirrored.Filled.List),
    DAILY_TASKS("daily", "Daily", Icons.Default.CheckCircle),
    READ_LATER("read_later", "Read Later", Icons.Default.Star),
    SETTINGS("settings", "Settings", Icons.Default.Settings),
}
