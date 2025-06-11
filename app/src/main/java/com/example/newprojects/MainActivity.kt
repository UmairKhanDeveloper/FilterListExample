package com.example.newprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newprojects.ui.theme.NewprojectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewprojectsTheme {
                FilteredScreen()
            }
        }
    }
}

data class Product(val name: String, val category: String)

@Composable
fun ProductFilterScreen() {
    var selectedCategory by remember { mutableStateOf("All") }

    val productList = listOf(
        Product("Burger", "Food"),
        Product("Pizza", "Food"),
        Product("Laptop", "Electronics"),
        Product("T-Shirt", "Clothing"),
        Product("Headphones", "Electronics"),
        Product("Jeans", "Clothing")
    )


    val categories = listOf("All", "Food", "Electronics", "Clothing")

    val filteredList = remember(selectedCategory) {
        if (selectedCategory == "All") {
            productList
        } else {
            productList.filter { it.category == selectedCategory }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            categories.forEach { categories ->
                Button(
                    onClick = { selectedCategory = categories },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = if (selectedCategory == categories) Color.Gray else Color.LightGray
                    )
                ) {
                    Text(text = categories)

                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            filteredList.forEach { product ->
                item {
                    Text(
                        text = "${product.name} (${product.category})",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

    }

}