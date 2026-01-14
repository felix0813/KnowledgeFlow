package com.wzf.knowledgeflow.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReadLaterScreen(modifier: Modifier = Modifier) {
    val links = listOf(
        "Compose layout cheatsheet",
        "Kotlin coroutines guide",
        "Jetpack performance tips"
    )
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(links) { link ->
            Text(text = link, modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}
