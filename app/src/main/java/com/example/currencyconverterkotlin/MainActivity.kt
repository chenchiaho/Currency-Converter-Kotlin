@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.currencyconverterkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyconverterkotlin.ui.screens.CurrencyConverterScreen
import com.example.currencyconverterkotlin.ui.theme.CurrencyConverterKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CurrencyConverterScreen()

                }
            }


        }
    }
}
//@Composable
//fun SimpleDropdownMenuExample() {
//    var expanded by remember { mutableStateOf(false) }
//    val items = listOf("Item 1", "Item 2", "Item 3")
//    var selectedIndex by remember { mutableStateOf(0) }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text("Selected item: ${items[selectedIndex]}",
//            modifier = Modifier.clickable { expanded = true })
//
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            items.forEachIndexed { index, item ->
//                DropdownMenuItem(
//                    text = { Text(text=item) },
//                    onClick = {
//                        selectedIndex = index
//                        expanded = false
//                    }
//                )
//            }
//        }
//    }
//}