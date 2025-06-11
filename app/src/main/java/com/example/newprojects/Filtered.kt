package com.example.newprojects

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilteredScreen() {
    var searchFruit by remember { mutableStateOf("") }
    var searchPerson by remember { mutableStateOf("") }
    var searchNumber by remember { mutableStateOf("") }
    var searchGrouped by remember { mutableStateOf("") }

    val fruitList = listOf("apple", "banana", "orange", "mango", "grape", "pineapple", "watermelon", "kiwi")
    val nameList = listOf("zain", "umair", "khubaib", "zohaib", "mubashir", "mudassir")
    val numberList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

    val allFruits = listOf(
        "Apple", "Apricot", "Avocado", "Banana", "Blackberry", "Blueberry",
        "Cherry", "Coconut", "Cranberry", "Date", "Dragonfruit", "Durian",
        "Fig", "Grape", "Guava", "Kiwi", "Lemon", "Lime", "Mango", "Melon",
        "Nectarine", "Orange", "Papaya", "Peach", "Pear", "Pineapple", "Plum",
        "Pomegranate", "Raspberry", "Strawberry", "Watermelon"
    )

    val filteredNames = nameList.filter { it.contains(searchPerson, ignoreCase = true) }
    val filteredNumbers = numberList.filter { it.contains(searchNumber, ignoreCase = true) }
    val filteredFruits = fruitList.filter { it.contains(searchFruit, ignoreCase = true) }
    val groupedFruits = allFruits.filter { it.contains(searchGrouped, ignoreCase = true) }
        .groupBy { it.first().uppercaseChar() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("Fruit List", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = searchFruit, onValueChange = { searchFruit = it }, label = { Text("Search Fruit") })
            Spacer(modifier = Modifier.height(8.dp))
            filteredFruits.forEach { fruit ->
                val isMatch = fruit.contains(searchFruit, ignoreCase = true)
                Text(
                    text = fruit,
                    color = if (isMatch) Color.Green else Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }


        item {
            Text("Person Name", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = searchPerson, onValueChange = { searchPerson = it }, label = { Text("Search Name") })
            Spacer(modifier = Modifier.height(8.dp))
            filteredNames.forEach { name ->
                Text(text = name, color = Color.Green, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(24.dp))
        }


        item {
            Text("Number List", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = searchNumber, onValueChange = { searchNumber = it }, label = { Text("Search Number") })
            Spacer(modifier = Modifier.height(8.dp))
            filteredNumbers.forEach { number ->
                Text(text = number, color = Color.Green, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(24.dp))
        }


        item {
            Text("Grouped Fruit Search", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = searchGrouped, onValueChange = { searchGrouped = it }, label = { Text("Search All Fruits") })
            Spacer(modifier = Modifier.height(8.dp))
        }

        groupedFruits.forEach { (letter, fruitsInGroup) ->
            item {
                Text(text = letter.toString(), fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }

            items(fruitsInGroup) { fruit ->
                Text(text = fruit, fontSize = 16.sp, color = Color.Green)
            }

            item { Spacer(modifier = Modifier.height(12.dp)) }
        }
    }
}


