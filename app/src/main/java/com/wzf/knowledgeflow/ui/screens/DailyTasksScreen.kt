package com.wzf.knowledgeflow.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DailyTasksScreen(modifier: Modifier = Modifier) {
    val tasks = listOf(
        "Review inbox",
        "Summarize 3 notes",
        "Practice 20 mins",
        "Ship 1 improvement"
    )
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(tasks) { task ->
            Text(text = "- $task", modifier = Modifier.padding(vertical = 6.dp))
        }
    }
}
