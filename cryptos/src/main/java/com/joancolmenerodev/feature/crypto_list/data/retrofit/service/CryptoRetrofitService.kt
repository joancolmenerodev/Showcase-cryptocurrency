package com.joancolmenerodev.feature.crypto_list.data.retrofit.service

import com.joancolmenerodev.feature.crypto_list.data.model.CryptoResponse
import retrofit2.http.GET

interface CryptoRetrofitService {

    @GET("v1/cryptocurrency/map?limit=50")
    suspend fun getCryptoCurrency(): CryptoResponse
}