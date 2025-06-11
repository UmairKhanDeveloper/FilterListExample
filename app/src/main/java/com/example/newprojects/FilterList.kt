package com.example.newprojects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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


@Composable
fun FilteredListScreen() {

    var searchGrouped by remember { mutableStateOf("") }

    val allFruits = listOf(
        "Apple", "Apricot", "Avocado", "Banana", "Blackberry", "Blueberry",
        "Cherry", "Coconut", "Cranberry", "Date", "Dragonfruit", "Durian",
        "Fig", "Grape", "Guava", "Kiwi", "Lemon", "Lime", "Mango", "Melon",
        "Nectarine", "Orange", "Papaya", "Peach", "Pear", "Pineapple", "Plum",
        "Pomegranate", "Raspberry", "Strawberry", "Watermelon"
    )

    val groupedFruits = allFruits.filter { it.contains(searchGrouped, ignoreCase = true) }
        .groupBy { it.first().uppercaseChar() }


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            TextField(value = searchGrouped, onValueChange = {
                searchGrouped = it
            })
        }
        groupedFruits.forEach { (letter, list) ->
            item {
                Text(
                    text = letter.toString(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray
                )
            }

            items(list) { fruit ->
                Text(text = fruit, fontSize = 8.sp, color = Color.Green)

            }


        }
    }


}