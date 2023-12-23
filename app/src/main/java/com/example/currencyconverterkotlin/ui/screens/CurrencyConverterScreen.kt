@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.currencyconverterkotlin.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.currencyconverterkotlin.ui.components.CurrencyDropdownMenu
import com.example.currencyconverterkotlin.ui.theme.CurrencyConverterKotlinTheme

@Composable
fun CurrencyConverterScreen() {
    // State variables
    var amount by remember { mutableStateOf("") }
    var selectedCurrencyFrom by remember { mutableStateOf("") }
    var selectedCurrencyTo by remember { mutableStateOf("") }
    var conversionResult by remember { mutableStateOf("") }

    // Sample currency list
    val currencyList = listOf("USD", "EUR", "JPY", "GBP")

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Currency Converter", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Convert currencies in real-time.")

        Spacer(modifier = Modifier.height(16.dp))
        // Amount input
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        // Dropdown for 'From' currency
        CurrencyDropdownMenu(
            currencyList,
            selectedCurrencyFrom,
            label = "From",
            onCurrencySelected = { selectedCurrencyFrom = it }
        )

        Spacer(modifier = Modifier.height(16.dp))
        // Dropdown for 'To' currency
        CurrencyDropdownMenu(
            currencyList,
            selectedCurrencyTo,
            label = "To",
            onCurrencySelected = { selectedCurrencyTo = it }
        )

        Spacer(modifier = Modifier.height(16.dp))
        // Convert button
        Button(onClick = {
            // Perform conversion logic here
            conversionResult = "Converted amount will be displayed here"
        }) {
            Text("Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Display conversion result
        Text(conversionResult, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyConverterScreenPreview() {
    CurrencyConverterKotlinTheme {
        CurrencyConverterScreen()
    }
}