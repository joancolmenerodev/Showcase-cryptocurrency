package com.joancolmenerodev.feature.crypto_list.domain.usecase

import com.joancolmenerodev.base.repository.CryptoRepository
import com.joancolmenerodev.feature.crypto_list.domain.exceptions.CryptoListExceptions
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto
import com.joancolmenerodev.library_base.Either
import com.joancolmenerodev.library_base.usecase.BaseUseCase
import javax.inject.Inject

class GetCryptoListUseCase @Inject constructor(private val cryptoRepository: CryptoRepository) :
    BaseUseCase() {

    suspend fun execute(limit: Int): Either<CryptoListExceptions, List<Crypto>> =
        toEither { cryptoRepository.getCoinList(limit) }

}