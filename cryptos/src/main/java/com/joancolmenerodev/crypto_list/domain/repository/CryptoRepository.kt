package com.joancolmenerodev.crypto_list.domain.repository

import com.joancolmenerodev.crypto_list.domain.model.Crypto

interface CryptoRepository {

    suspend fun getCoinList(): List<Crypto>

}