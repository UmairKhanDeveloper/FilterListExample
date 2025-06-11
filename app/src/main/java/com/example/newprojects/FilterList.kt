package com.example.newprojects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterListExample() {
    var searchBar by remember { mutableStateOf("") }


    val studentName = listOf("umair", "khan", "zain", "arif", "masood", "zohaib", "nasir")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = searchBar,
            onValueChange = { searchBar = it },
            label = { Text("Search student") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        studentName.forEach { name ->
            val isMatch = name.contains(searchBar, ignoreCase = true) && searchBar.isNotBlank()
            Text(
                text = name,
                color = if (isMatch) Color.Green else Color.Red,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
