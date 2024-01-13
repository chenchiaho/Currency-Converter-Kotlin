package com.example.currencyconverterkotlin.network

import com.example.currencyconverterkotlin.model.CurrencyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApiService {
    @GET("latest")
    fun getRates(
        @Query("base_currency") baseCurrency: String,
        @Query("apikey") apikey: String = "f8fbdc40-5398-11ec-b8f1-757e371ba593"
    ): Call<CurrencyResponse>
}