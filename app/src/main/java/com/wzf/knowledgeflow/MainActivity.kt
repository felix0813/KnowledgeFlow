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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.wzf.knowledgeflow.ui.theme.KnowledgeFlowTheme
import com.wzf.knowledgeflow.ui.screens.DailyTasksScreen
import com.wzf.knowledgeflow.ui.screens.KnowledgeListScreen
import com.wzf.knowledgeflow.ui.screens.ReadLaterScreen
import com.wzf.knowledgeflow.ui.screens.SettingsScreen

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
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.KNOWLEDGE_LIST) }

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
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            when (currentDestination) {
                AppDestinations.KNOWLEDGE_LIST -> KnowledgeListScreen(Modifier.padding(innerPadding))
                AppDestinations.DAILY_TASKS -> DailyTasksScreen(Modifier.padding(innerPadding))
                AppDestinations.READ_LATER -> ReadLaterScreen(Modifier.padding(innerPadding))
                AppDestinations.SETTINGS -> SettingsScreen(Modifier.padding(innerPadding))
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector,
) {
    KNOWLEDGE_LIST("Knowledge", Icons.AutoMirrored.Filled.List),
    DAILY_TASKS("Daily", Icons.Default.CheckCircle),
    READ_LATER("Read Later", Icons.Default.Star),
    SETTINGS("Settings", Icons.Default.Settings),
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KnowledgeFlowTheme {
        KnowledgeListScreen()
    }
}



