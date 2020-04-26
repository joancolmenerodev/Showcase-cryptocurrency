package com.joancolmenerodev.crypto_list.data.retrofit.service

import com.joancolmenerodev.crypto_list.data.model.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET

interface CryptoRetrofitService {

    @GET("v1/cryptocurrency/map?limit=50")
    suspend fun getCryptoCurrency(): Response<CryptoResponse>
}