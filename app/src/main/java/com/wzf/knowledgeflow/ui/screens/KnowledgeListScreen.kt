package com.wzf.knowledgeflow.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun KnowledgeListScreen(modifier: Modifier = Modifier) {
    val items = listOf(
        "Compose basics",
        "State and effects",
        "Navigation patterns",
        "Room + Flow",
        "Performance checklist"
    )
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(items) { item ->
            Text(text = item, modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}
