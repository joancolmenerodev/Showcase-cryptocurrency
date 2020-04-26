package com.joancolmenerodev.crypto_list.data.repository

import com.joancolmenerodev.crypto_list.data.model.toDomainModel
import com.joancolmenerodev.crypto_list.data.retrofit.service.CryptoRetrofitService
import com.joancolmenerodev.crypto_list.domain.model.CoinList
import com.joancolmenerodev.crypto_list.domain.repository.CryptoRepository
import com.joancolmenerodev.library_base.Either
import com.joancolmenerodev.library_base.ErrorEntity
import com.joancolmenerodev.library_base.retrofit.safeCall
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val cryptoRetrofitService: CryptoRetrofitService) :
    CryptoRepository {

    override suspend fun getCoinList(): Either<ErrorEntity, List<CoinList>> =
        cryptoRetrofitService.getCryptoCurrency().safeCall {
            it.toDomainModel()
        }
}
