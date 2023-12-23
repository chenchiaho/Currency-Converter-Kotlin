@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.currencyconverterkotlin.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CurrencyDropdownMenu(
    currencyList: List<String>,
    selectedCurrency: String,
    label: String,
    onCurrencySelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(selectedCurrency) }

    OutlinedTextField(
        value = selectedOptionText,
        onValueChange = { selectedOptionText = it },
        label = { Text(label) },
        readOnly = true,
        trailingIcon = { Icon(Icons.Filled.ArrowDropDown, contentDescription = null) },
        modifier = Modifier.clickable { expanded = true }
    )
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        currencyList.forEach { currency ->
            DropdownMenuItem(
                { Text(currency) },
                onClick = {
                    selectedOptionText = currency
                    onCurrencySelected(currency)
                    expanded = false
                }
            )
        }
    }
}