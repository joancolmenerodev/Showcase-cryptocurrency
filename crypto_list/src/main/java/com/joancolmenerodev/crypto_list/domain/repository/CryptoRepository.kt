package com.joancolmenerodev.crypto_list.domain.repository

import com.joancolmenerodev.crypto_list.domain.model.CoinList
import com.joancolmenerodev.library_base.Either
import com.joancolmenerodev.library_base.ErrorEntity

interface CryptoRepository {

    suspend fun getCoinList(): Either<ErrorEntity, List<CoinList>>

}