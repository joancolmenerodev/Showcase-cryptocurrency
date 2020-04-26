package com.joancolmenerodev.crypto_list.domain.usecase

import com.joancolmenerodev.crypto_list.domain.repository.CryptoRepository
import javax.inject.Inject

class GetCryptoListUseCase @Inject constructor(private val cryptoRepository: CryptoRepository) {

    suspend fun execute() = cryptoRepository.getCoinList()
}