package com.joancolmenerodev.feature.crypto_list.domain.repository

import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto

interface CryptoRepository {

    suspend fun getCoinList(): List<Crypto>

}