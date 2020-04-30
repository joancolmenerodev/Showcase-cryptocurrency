package com.joancolmenerodev.base.retrofit.service

import com.joancolmenerodev.feature.crypto_detail.data.model.CryptoDetailResponse
import com.joancolmenerodev.feature.crypto_list.data.model.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoRetrofitService {

    @GET("v1/cryptocurrency/map")
    suspend fun getCryptoCurrency(@Query("limit") limit: Int): CryptoResponse

    @GET("v1/cryptocurrency/info")
    suspend fun getCryptoInfo(@Query("id") id: Int): CryptoDetailResponse
}