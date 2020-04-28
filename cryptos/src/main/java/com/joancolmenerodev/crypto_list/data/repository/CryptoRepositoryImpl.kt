package com.joancolmenerodev.crypto_list.data.repository

import com.joancolmenerodev.crypto_list.data.model.map
import com.joancolmenerodev.crypto_list.data.retrofit.service.CryptoRetrofitService
import com.joancolmenerodev.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.crypto_list.domain.model.Crypto
import com.joancolmenerodev.crypto_list.domain.repository.CryptoRepository
import com.joancolmenerodev.library_base.repository.BaseRepository
import com.joancolmenerodev.library_base.service.ClientException
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val cryptoRetrofitService: CryptoRetrofitService) :
    CryptoRepository, BaseRepository() {

    override suspend fun getCoinList(): List<Crypto> = execute {
        try {
            cryptoRetrofitService.getCryptoCurrency().map()
        } catch (exception: ClientException) {
            when (exception) {
                is ClientException.NotFound -> throw CryptoListExceptions.CryptoListNotFound
                else -> throw CryptoListExceptions.CryptoListNotAvailable
            }
        }
    }
}
