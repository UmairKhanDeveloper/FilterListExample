package com.example.newprojects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun Filtered() {

    var searchBar by remember { mutableStateOf("") }

    val nameList = listOf(
        "apple", "banana", "orange", "mango", "grape", "pineapple", "watermelon", "kiwi",
        "peach", "plum", "pear", "cherry", "strawberry", "blueberry", "blackberry", "papaya",
        "guava", "pomegranate", "lychee", "apricot", "coconut", "lemon", "lime", "fig",
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = searchBar, onValueChange = {
            searchBar = it
        })

        nameList.forEach { name ->
            val isMatch = name.contains(searchBar, ignoreCase = true) && searchBar.isNotBlank()

            Text(text = name, color = if (isMatch) Color.Gray else Color.Red)
        }

    }

}