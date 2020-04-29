package com.joancolmenerodev.base.repository

import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto

interface CryptoRepository {

    suspend fun getCoinList(): List<Crypto>
    suspend fun getCoinDetail(cryptoId: Int) : CryptoDetail

}