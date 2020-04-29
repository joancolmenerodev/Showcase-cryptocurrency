package com.joancolmenerodev.feature.crypto_detail.domain.usecase

import com.joancolmenerodev.base.repository.CryptoRepository
import com.joancolmenerodev.feature.crypto_detail.domain.exceptions.CryptoDetailExceptions
import com.joancolmenerodev.feature.crypto_detail.domain.model.CryptoDetail
import com.joancolmenerodev.library_base.Either
import com.joancolmenerodev.library_base.usecase.BaseUseCase
import javax.inject.Inject

class GetCryptoDetailUseCase @Inject constructor(private val cryptoRepository: CryptoRepository) :
    BaseUseCase() {

    suspend fun execute(cryptoId: Int): Either<CryptoDetailExceptions, CryptoDetail> =
        toEither { cryptoRepository.getCoinDetail(cryptoId) }

}