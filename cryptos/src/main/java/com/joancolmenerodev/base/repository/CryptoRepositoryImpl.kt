package com.joancolmenerodev.base.repository

import com.joancolmenerodev.base.retrofit.service.CryptoRetrofitService
import com.joancolmenerodev.feature.crypto_detail.data.model.map
import com.joancolmenerodev.feature.crypto_detail.domain.exceptions.CryptoDetailExceptions
import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import com.joancolmenerodev.feature.crypto_list.data.model.map
import com.joancolmenerodev.feature.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import com.joancolmenerodev.library_base.repository.BaseRepository
import com.joancolmenerodev.library_base.exceptions.ClientException
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val cryptoRetrofitService: CryptoRetrofitService) :
    CryptoRepository, BaseRepository() {

    override suspend fun getCoinList(limit: Int): List<Crypto> = execute {
        try {
            cryptoRetrofitService.getCryptoCurrency(limit).map()
        } catch (exception: Exception) {
            when (exception) {
                is ClientException.NotFound -> throw CryptoListExceptions.CryptoListNotFound
                else -> throw CryptoListExceptions.CryptoListNotAvailable
            }
        }
    }

    override suspend fun getCoinDetail(cryptoId: Int): CryptoDetail = execute {
        try {
            cryptoRetrofitService.getCryptoInfo(id = cryptoId).map()
        } catch (exception: Exception) {
            when (exception) {
                is ClientException.NotFound -> throw CryptoDetailExceptions.CryptoNotFound
                else -> throw CryptoDetailExceptions.CryptoUnavailable
            }
        }
    }
}
