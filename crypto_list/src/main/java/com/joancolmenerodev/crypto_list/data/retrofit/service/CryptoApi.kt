package com.joancolmenerodev.crypto_list.data.retrofit.service

import com.joancolmenerodev.crypto_list.data.model.CryptoResponse

interface CryptoApi {
    suspend fun getCryptoList() : CryptoResponse
}