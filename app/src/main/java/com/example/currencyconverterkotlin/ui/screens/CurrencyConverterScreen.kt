@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.currencyconverterkotlin.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.example.currencyconverterkotlin.network.RetrofitInstance
import com.example.currencyconverterkotlin.ui.components.CurrencyDropdownMenu
import com.example.currencyconverterkotlin.ui.theme.CurrencyConverterKotlinTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyConverterScreen() {
    // State variables
    var amount by remember { mutableStateOf("") }
    var selectedCurrencyFrom = "SGD"
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
            currencyList = listOf("JPY"),
            selectedCurrencyTo,
            label = "To",
            onCurrencySelected = { selectedCurrencyTo = it }
        )

        Spacer(modifier = Modifier.height(16.dp))
        // Convert button
        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                val response = RetrofitInstance.api.getRates("SGD").execute()
                if (response.isSuccessful && response.body() != null) {

                    val rates = response.body()!!.data
                    val rateToJPY = rates["JPY"] ?: 0.0

                    withContext(Dispatchers.Main) {
                        if (amount.isNotEmpty() && selectedCurrencyTo == "JPY") {
                            val convertedAmount = amount.toDoubleOrNull()?.times(rateToJPY)
                            conversionResult = if (convertedAmount != null)
                                "Converted: $convertedAmount JPY"
                            else
                                "Invalid amount entered"
                        } else {
                            conversionResult = "Please enter an amount and select a currency"
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        conversionResult = "Error: ${response.code()} - ${response.message()}"
                    }
                }
            }

        }) {
            Text("Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))
        // Display conversion result
        Text(conversionResult, style = MaterialTheme.typography.bodyLarge)


    }
}

